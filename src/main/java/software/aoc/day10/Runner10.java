package software.aoc.day10;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Stream;

public record Runner10(Stream<Machine> machines) {
    public static Runner10 with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return new Runner10(reader.readAllLines().stream().map(Machine::from));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long run() {
        return machines.mapToInt(Machine::solveDesiredState).sum();
    }

    public long runB() {
        return machines.mapToInt(m -> m.solveVoltageRequirements(new HashMap<>())).sum();
    }
}
