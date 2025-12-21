package software.aoc.day04;

import java.util.stream.Stream;

public record Position(int row, int col) {
    public Stream<Position> neighborRanges() {
        return Stream.of(new Position(row-1, col-1)
                , new Position(row-1, col)
                , new Position(row-1, col+1)
                , new Position(row, col-1)
                , new Position(row, col+1)
                , new Position(row+1, col-1)
                , new Position(row+1, col)
                , new Position(row+1, col+1));
    }
}
