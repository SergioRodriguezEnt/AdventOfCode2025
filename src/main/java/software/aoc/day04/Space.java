package software.aoc.day04;

public enum Space {
    EMPTY, PAPER;

    public static Space from(char space) {
        return space == '@' ? PAPER : EMPTY;
    }

    @Override
    public String toString() {
        return this == Space.PAPER ? "@" : ".";
    }
}
