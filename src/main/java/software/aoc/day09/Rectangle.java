package software.aoc.day09;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public record Rectangle(Coordinate coord1, Coordinate coord2) {
    public long width() {
        return Math.abs(coord1.x() - coord2.x())+1;
    }

    public long height() {
        return Math.abs(coord1.y() - coord2.y())+1;
    }

    public long area() {
        return width() * height();
    }

    public boolean isLine() {
        return coord1.x() == coord2.x() || coord1.y() == coord2.y();
    }

    long minX() { return Math.min(coord1.x(), coord2.x()); }
    long maxX() { return Math.max(coord1.x(), coord2.x()); }
    long minY() { return Math.min(coord1.y(), coord2.y()); }
    long maxY() { return Math.max(coord1.y(), coord2.y()); }

    public boolean overlaps(Rectangle other) {
        return maxX() >= other.minX() && other.maxX() >= minX() && maxY() >= other.minY() && other.maxY() >= minY();
    }

    public Stream<Coordinate> edges() {
        return Stream.concat(
                LongStream.rangeClosed(minX(), maxX())
                        .mapToObj(x -> Stream.of(
                                new Coordinate(x, minY()),
                                new Coordinate(x, maxY())
                        )).flatMap(s -> s),
                LongStream.rangeClosed(minY() + 1, maxY() - 1)
                        .mapToObj(y -> Stream.of(
                                new Coordinate(minX(), y),
                                new Coordinate(maxX(), y)
                        )).flatMap(s->s)
        );
    }

    public boolean contains(Coordinate coord) {
        return coord.x() >= minX() && coord.x() <= maxX() && coord.y() >= minY() && coord.y() <= maxY();
    }
}
