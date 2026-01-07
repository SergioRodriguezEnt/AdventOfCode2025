package software.aoc.day12;

import java.util.List;
import java.util.stream.IntStream;

public record Present(List<Coordinate> coordinates) {
    public static Present from(List<String> strs) {
        return new Present(IntStream.range(1, strs.size())
                .mapToObj(i -> IntStream.range(0, 3)
                        .filter(j -> strs.get(i).charAt(j) == '#')
                        .mapToObj(j -> new Coordinate(j - 1, i - 2)))
                .flatMap(s -> s)
                .toList());
    }

    public int area() {
        return coordinates.size();
    }

    public Present flippedHorizontal() {
        return new Present(coordinates.stream().map(c -> new Coordinate(-c.x(), c.y())).toList());
    }

    public Present rotateLeft() {
        return new Present(coordinates.stream().map(c -> new Coordinate(-c.y(), c.x())).toList());
    }
}
