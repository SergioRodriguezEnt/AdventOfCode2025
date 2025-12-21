package software.aoc.day04.b;

import software.aoc.day04.Position;
import software.aoc.day04.Space;
import software.aoc.day04.Wall;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record WallRemover(Wall wall) {
    public WallRemover removePositions(Stream<Position> positions) {
        Set<Position> toRemove = positions.collect(Collectors.toSet());
        return new WallRemover(Wall.from(wall
                .positionRowStream()
                .map(rowStream -> rowStream
                        .map(pos -> newState(pos, toRemove).toString())
                        .collect(Collectors.joining())
                )
                .toList()
        ));
    }

    private Space newState(Position pos, Set<Position> toRemove) {
        if (toRemove.contains(pos)) return Space.EMPTY;
        return wall.spaceAt(pos);
    }
}
