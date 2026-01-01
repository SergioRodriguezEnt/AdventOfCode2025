package software.aoc.day08.a;

import software.aoc.day08.Box;
import software.aoc.day08.BoxPair;
import software.aoc.day08.Circuit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record CircuitConnectorA(List<Circuit> circuits) {
    public Stream<BoxPair> distances(List<Box> boxes, long n) {
        return IntStream.range(0, boxes.size())
                .parallel()
                .mapToObj(i -> IntStream.range(i + 1, boxes.size())
                        .mapToObj(boxes::get)
                        .map(box2 -> new BoxPair(boxes.get(i), box2, boxes.get(i).distanceTo(box2)))
                ).flatMap(s -> s)
                .sorted(Comparator.comparingDouble(BoxPair::distance))
                .limit(n);
    }

    public List<Circuit> connect(long n) {
        ArrayList<Circuit> circuits = new ArrayList<>(this.circuits);
        distances(boxes(), n).sequential().forEachOrdered(pair -> {
            Circuit c1 = circuitOf(pair.box1(), circuits);
            if (c1.boxes().contains(pair.box2())) return;
            Circuit c2 = circuitOf(pair.box2(), circuits);
            circuits.remove(c1);
            circuits.remove(c2);
            circuits.add(new Circuit(Stream.concat(c1.boxes().stream(), c2.boxes().stream()).collect(Collectors.toSet())));
        });
        return circuits;
    }

    public int connectionCostFor(long n) {
        return connect(n).stream()
                .map(c -> c.boxes().size())
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToInt(num -> num)
                .reduce(1, Math::multiplyExact);
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
