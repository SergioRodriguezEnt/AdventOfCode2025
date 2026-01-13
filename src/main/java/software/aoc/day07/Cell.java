package software.aoc.day07;

import java.util.List;

public record Cell(Space space, long paths) {

    public static Cell empty() {
        return new Cell(Space.EMPTY, 0);
    }

    public static Cell splitter() {
        return new Cell(Space.SPLITTER, 0);
    }

    public static Cell newBeam() {
        return new Cell(Space.BEAM, 1);
    }

    public static Cell beam(long paths) {
        return new Cell(Space.BEAM, paths);
    }

    public static Cell from (char c) {
        return c == '.' ? empty() : (c == '^' ? splitter() : newBeam());
    }

    public static List<Cell> parse(String str) {
        return str.chars().mapToObj(c -> from((char) c)).toList();
    }

    public boolean isEmpty() {
        return space == Space.EMPTY;
    }

    public boolean isSplitter() {
        return space == Space.SPLITTER;
    }

    public boolean isBeam() {
        return space == Space.BEAM;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public String toString() {
        if (isEmpty()) return ".";
        if (isSplitter()) return "^";
        if (isBeam()) return String.valueOf(paths);
        return "S";
    }

    public enum Space {
        EMPTY, SPLITTER, BEAM
    }
}