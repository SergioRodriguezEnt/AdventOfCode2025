package software.aoc.day04.b;

import software.aoc.day04.Runner04;
import software.aoc.day04.Wall;
import software.aoc.day04.WallAnalyzer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Runner04B implements Runner04 {
    private Wall wall;
    public Runner04B(InputStream file) {
        wall = wallFrom(file);
    }

    @Override
    public long run() {
        WallAnalyzer analyzer = new WallAnalyzer(wall);
        long result = analyzer.getRemovableRollCount();
        while (analyzer.getRemovableRollCount() != 0) {
            wall = new WallRemover(wall).removePositions(analyzer.getRemovableRolls()).wall();
            analyzer = new WallAnalyzer(wall);
            result += analyzer.getRemovableRollCount();
        }
        return result;
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
