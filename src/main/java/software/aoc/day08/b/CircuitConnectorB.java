package software.aoc.day08.b;

import software.aoc.day08.Box;
import software.aoc.day08.BoxPair;
import software.aoc.day08.Circuit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record CircuitConnectorB(List<Circuit> circuits) {
    public Stream<BoxPair> distances(List<Box> boxes) {
        return IntStream.range(0, boxes.size())
                .parallel()
                .mapToObj(i -> IntStream.range(i + 1, boxes.size())
                        .mapToObj(boxes::get)
                        .map(box2 -> new BoxPair(boxes.get(i), box2, boxes.get(i).distanceTo(box2)))
                ).flatMap(s -> s)
                .sorted(Comparator.comparingDouble(BoxPair::distance));
    }

    public BoxPair connect() {
        ArrayList<Circuit> circuits = new ArrayList<>(this.circuits);
        AtomicReference<BoxPair> finalPair = new AtomicReference<>();
        distances(boxes()).sequential().forEachOrdered(pair -> {
            Circuit c1 = circuitOf(pair.box1(), circuits);
            if (c1.boxes().contains(pair.box2())) return;
            Circuit c2 = circuitOf(pair.box2(), circuits);
            circuits.remove(c1);
            circuits.remove(c2);
            circuits.add(new Circuit(Stream.concat(c1.boxes().stream(), c2.boxes().stream()).collect(Collectors.toSet())));
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
