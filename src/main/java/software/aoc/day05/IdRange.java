package software.aoc.day05;

import java.util.Arrays;

public record IdRange(long min, long max) {
    public IdRange(String str) {
        long[] bounds = Arrays.stream(str.split("-")).mapToLong(Long::valueOf).toArray();
        this(bounds[0], bounds[1]);
    }

    public boolean overlapsWith(IdRange other) {
        return max >= other.min && min <= other.max;
    }

    public boolean contains(long value) {
        return value >= min && value <= max;
    }

    public boolean isSmallerThan(IdRange other) {
        return max < other.min;
    }

    public IdRange combineWith(IdRange other) {
        return new IdRange(Math.min(min, other.min), Math.max(max, other.max));
    }
}
