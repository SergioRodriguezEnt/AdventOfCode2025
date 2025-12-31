package software.aoc.day06;

import java.util.stream.Stream;

public interface OperationBuilder {
    OperationBuilder add(String str);
    Stream<Operation> build();
}
