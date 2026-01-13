package software.aoc.day12;

public record Coordinate(int x, int y) {
    public Coordinate move(Coordinate vector) {
        return new Coordinate(x+vector.x(), y+vector.y());
    }
}
