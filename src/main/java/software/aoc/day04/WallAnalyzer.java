package software.aoc.day04;

import java.util.stream.Stream;

public record WallAnalyzer(Wall wall) {
    public long getRemovableRollCount() {
        return this.getRemovableRolls().count();
    }

    public Stream<Position> getRemovableRolls() {
        return wall.getPositions().filter(pos -> wall.spaceAt(pos) == Space.PAPER).filter(pos -> !isSurrounded(pos));
    }

    private boolean isSurrounded(Position pos) {
        return pos.neighborRanges()
                .map(wall::spaceAt)
                .filter(space -> space == Space.PAPER)
                .count() >= 4;
    }
}
