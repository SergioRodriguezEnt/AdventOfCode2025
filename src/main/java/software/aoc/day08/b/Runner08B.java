package software.aoc.day08.b;

import software.aoc.day08.Circuit;
import software.aoc.day08.CircuitConnector;
import software.aoc.day08.CircuitLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public record Runner08B(List<Circuit> circuits) {
    public static Runner08B with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            CircuitLoader loader = new CircuitLoader();
            reader.readAllLines().forEach(loader::add);
            return new Runner08B(loader.loadAll());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long run() {
        return new CircuitConnector(circuits).connectionCost();
    }
}
