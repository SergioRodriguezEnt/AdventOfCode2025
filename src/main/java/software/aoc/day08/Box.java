package software.aoc.day08;

public record Box(int x, int y, int z) {
    public double distanceTo(Box other) {
        return Math.sqrt(Math.pow(x - other.x(), 2) + Math.pow(y - other.y(), 2) + Math.pow(z - other.z(), 2));
    }
}
