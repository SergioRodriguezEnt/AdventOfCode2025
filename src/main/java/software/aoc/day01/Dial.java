package software.aoc.day01;

public record Dial(int position) {
    public Dial() {
        this(50);
    }

    public Dial(int position) {
        this.position = normalize(position);
    }

    private static int normalize(int position) {
        return ((position % 100) + 100) % 100;
    }
}
