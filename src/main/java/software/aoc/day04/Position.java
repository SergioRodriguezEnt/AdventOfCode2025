package software.aoc.day04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Position(int row, int col) {
    public Stream<Position> neighborRanges() {
        return IntStream.rangeClosed(row-1, row+1)
                .mapToObj(r -> IntStream.rangeClosed(col-1, col+1)
                        .mapToObj(c -> new Position(r, c)))
                .flatMap(s -> s)
                .filter(c -> !c.equals(this));
    }
}
