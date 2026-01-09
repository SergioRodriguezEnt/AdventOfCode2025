package software.aoc.day08;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public record Runner08(List<Circuit> circuits) {
    public static Runner08 with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            CircuitLoader loader = new CircuitLoader();
            reader.readAllLines().forEach(loader::add);
            return new Runner08(loader.loadAll());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long runFor(long maxPairsAfterSort) {
        return new CircuitConnector(circuits).connectionCostFor(maxPairsAfterSort);
    }

    public long run() {
        return new CircuitConnector(circuits).connectionCost();
    }
}
