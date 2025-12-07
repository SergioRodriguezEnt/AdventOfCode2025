package software.aoc.day02;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public record IdRange(long startId, long endId) {
    public IdRange(String range) {
        int i = range.indexOf('-');
        this(Long.parseLong(range.substring(0, i)), Long.parseLong(range.substring(i + 1)));
    }

    public LongStream getIds() {
        return LongStream.range(startId, endId + 1);
    }

    public LongStream getInvalidIds(LongPredicate condition) {
        return getIds().filter(condition.negate());
    }
}
