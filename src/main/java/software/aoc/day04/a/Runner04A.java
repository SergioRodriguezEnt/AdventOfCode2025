package software.aoc.day04.a;

import software.aoc.day04.Runner04;
import software.aoc.day04.Wall;
import software.aoc.day04.WallAnalyzer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public record Runner04A(Wall wall) implements Runner04 {
    public Runner04A(InputStream file) {
        this(wallFrom(file));
    }

    @Override
    public long run() {
        return new WallAnalyzer(wall).getRemovableRollCount();
    }

    private static Wall wallFrom(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return Wall.from(reader.readAllLines());
        } catch (IOException exception) {
            System.err.println("Error while reading from file: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }
}
