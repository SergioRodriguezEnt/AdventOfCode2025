package software.aoc.day03;

import java.util.Arrays;
import java.util.stream.IntStream;

public record Bank(int[] batteries) {
    public Bank(String str) {
        this(str.chars().map(c -> c - '0').toArray());
    }

    public IntStream batteryStream() {
        return Arrays.stream(batteries);
    }
}
