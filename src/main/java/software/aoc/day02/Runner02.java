package software.aoc.day02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public record Runner02(Stream<IdRange> idRanges, LongPredicate validator) {
    public Runner02(InputStream file, LongPredicate validator) {
        this(idRangesFrom(file), validator);
    }

    public long run() {
        return idRanges.map(range -> range.getInvalidIds(validator)).mapToLong(LongStream::sum).sum();
    }

    private static Stream<IdRange> idRangesFrom(InputStream file) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            return Arrays.stream(reader.readAllAsString().split(",")).map(IdRange::new);
        } catch (IOException exception) {
            System.err.println("Error while reading from file: " + exception.getMessage());
            throw new RuntimeException(exception);
        }
    }
}

