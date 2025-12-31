package software.aoc.day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public record Runner06(Stream<Operation> operations) {
    public static Runner06 with(InputStream file, OperationBuilder builder) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            reader.readAllLines().forEach(builder::add);
            return new Runner06(builder.build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long run() {
        return operations.mapToLong(Operation::operate).sum();
    }
}
