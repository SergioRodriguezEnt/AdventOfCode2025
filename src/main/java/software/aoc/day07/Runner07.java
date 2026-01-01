package software.aoc.day07;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public record Runner07(List<List<Cell>> grid) {
    public static Runner07 with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            GridBuilder builder = new GridBuilder();
            reader.readAllLines().forEach(builder::add);
            return new Runner07(builder.build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getSplits() {
        return new GridUpdater(grid, 0, 1).resolve().count();
    }

    public long getPaths() {
        return new GridUpdater(grid, 0, 1).resolve().grid().getLast()
                .stream()
                .filter(Cell::isBeam)
                .mapToLong(Cell::paths)
                .sum();
    }
}
