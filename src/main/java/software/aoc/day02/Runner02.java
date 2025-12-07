package software.aoc.day02;

import software.aoc.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Runner02 implements Runner<Long> {
    private Stream<IdRange> ranges;
    private final LongPredicate condition;

    public Runner02(LongPredicate condition) {
        this.condition = condition;
    }

    @Override
    public Long runFrom(InputStream file) {
        try (InputStreamReader isr = new InputStreamReader(file); BufferedReader br = new BufferedReader(isr)) {
            loadRangesFrom(br);
            return validateRanges();
        } catch (IOException e) {
            System.err.println("Error while reading instructions from file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void loadRangesFrom(BufferedReader br) throws IOException {
        ranges = Arrays.stream(br.readLine().split(",")).map(IdRange::new);
    }

    private Long validateRanges() {
        return ranges.map(range -> range.getInvalidIds(condition)).mapToLong(LongStream::sum).sum();
    }
}
