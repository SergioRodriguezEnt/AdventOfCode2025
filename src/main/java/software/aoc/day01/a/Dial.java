package software.aoc.day01.a;

public record Dial(int position) {
    public Dial() {
        this(50);
    }

    public int position() {
        return normalize(position);
    }

    private static int normalize(int position) {
        return position % 100 + (position < 0 ? 100 : 0);
    }
}
