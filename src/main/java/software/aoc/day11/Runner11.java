package software.aoc.day11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public record Runner11(List<String> input) {
    public static Runner11 with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return new Runner11(reader.readAllLines());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long findNormalPaths() {
        return PathFinder.from(input).paths();
    }

    public long findServerPaths() {
        return PathFinder.from(input).serverPaths();
    }
}
