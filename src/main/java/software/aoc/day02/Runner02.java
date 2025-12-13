package software.aoc.day02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public record Runner02(Stream<IdRange> idRanges, LongPredicate validationCondition) {
    public Runner02(InputStream fileStream, LongPredicate validationCondition) {
        this(idRangesFrom(fileStream), validationCondition);
    }

    private static Stream<IdRange> idRangesFrom(InputStream fileStream) {
        try (InputStreamReader isr = new InputStreamReader(fileStream)) {
            return Arrays.stream(isr.readAllAsString().split(",")).map(IdRange::new);
        } catch (IOException e) {
            System.err.println("Error while reading from file: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public long run() {
        return idRanges.map(range -> range.getInvalidIds(validationCondition)).mapToLong(LongStream::sum).sum();
    }
}

