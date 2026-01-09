package software.aoc.day08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record CircuitConnector(List<Circuit> circuits) {
    private Stream<BoxPair> boxPairsFor(List<Box> boxes, long n) {
        return IntStream.range(0, boxes.size())
                .parallel()
                .mapToObj(i -> IntStream.range(i + 1, boxes.size())
                        .mapToObj(boxes::get)
                        .map(box2 -> new BoxPair(boxes.get(i), box2, boxes.get(i).distanceTo(box2)))
                ).flatMap(s -> s)
                .sorted(Comparator.comparingDouble(BoxPair::distance))
                .limit(n);
    }

    private List<Circuit> connectFor(long n) {
        ArrayList<Circuit> circuits = new ArrayList<>(this.circuits);
        boxPairsFor(boxes(), n).sequential()
                .filter(pair->!circuitOf(pair.box1(), circuits).boxes().contains(pair.box2()))
                .forEachOrdered(pair -> combineInto(pair, circuits));
        return circuits;
    }

    private void combineInto(BoxPair pair, ArrayList<Circuit> circuits) {
        Circuit c1 = circuitOf(pair.box1(), circuits);
        Circuit c2 = circuitOf(pair.box2(), circuits);
        circuits.remove(c1);
        circuits.remove(c2);
        circuits.add(new Circuit(Stream.concat(c1.boxes().stream(), c2.boxes().stream()).collect(Collectors.toSet())));
    }

    public int connectionCostFor(long n) {
        return connectFor(n).stream()
                .map(c -> c.boxes().size())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(num -> num)
                .reduce(1, Math::multiplyExact);
    }

    private BoxPair connect() {
        ArrayList<Circuit> circuits = new ArrayList<>(this.circuits);
        AtomicReference<BoxPair> finalPair = new AtomicReference<>();
        boxPairsFor(boxes(), 99999).sequential()
                .filter(pair->!circuitOf(pair.box1(), circuits).boxes().contains(pair.box2()))
                .forEachOrdered(pair -> {
                    combineInto(pair, circuits);
                    if (circuits.size() == 1) finalPair.set(pair);
                });
        return finalPair.get();
    }

    public long connectionCost() {
        BoxPair pair = connect();
        return ((long)pair.box1().x())*pair.box2().x();
    }

    private Circuit circuitOf(Box box, List<Circuit> circuits) {
        for (Circuit circuit : circuits) {
            if (circuit.boxes().contains(box)) return circuit;
        }
        return circuits.getFirst();
    }

    private List<Box> boxes() {
        return circuits.stream().flatMap(c -> c.boxes().stream()).toList();
    }
}
