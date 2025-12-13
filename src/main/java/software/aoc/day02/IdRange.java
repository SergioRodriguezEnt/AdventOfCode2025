package software.aoc.day02;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public record IdRange(long startId, long endId) {
    public IdRange(String idRange) {
        int middleIndex = idRange.indexOf('-');
        this(Long.parseLong(idRange.substring(0, middleIndex)), Long.parseLong(idRange.substring(middleIndex + 1)));
    }

    public LongStream getIds() {
        return LongStream.range(startId, endId + 1);
    }

    public LongStream getInvalidIds(LongPredicate validationCondition) {
        return getIds().filter(validationCondition.negate());
    }
}
