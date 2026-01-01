package software.aoc.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CircuitLoader {
    private final List<Circuit> circuits;

    public CircuitLoader() {
        circuits = new ArrayList<>();
    }

    public CircuitLoader add(String str) {
        int[] coords = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
        circuits.add(new Circuit(Set.of(new Box(coords[0], coords[1], coords[2]))));
        return this;
    }

    public List<Circuit> loadAll() {
        return circuits;
    }
}
