package software.aoc.day09;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public record Runner09(List<Coordinate> redTiles) {
    public static Runner09 with(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return new Runner09(reader.readAllLines().stream().map(Coordinate::from).toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getArea() {
        return new RectangleFinder(redTiles).biggest().area();
    }

    public long getAllowedArea() {
        return new RectangleFinder(redTiles).biggestAllowed().area();
    }
}
