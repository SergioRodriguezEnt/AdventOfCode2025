package software.aoc.day06;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public record Runner06(Stream<Operation> operations) {
    public static Runner06 with(InputStream file, BuildingComplexity complexity) {
        try (InputStreamReader reader = new InputStreamReader(file)) {
            OperationBuilder builder = new OperationBuilder();
            reader.readAllLines().forEach(builder::add);
            return new Runner06(complexity == BuildingComplexity.SIMPLE ? builder.buildSimple() : builder.buildComplex());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long run() {
        return operations.mapToLong(Operation::operate).sum();
    }

    public enum BuildingComplexity {SIMPLE, COMPLEX}
}
