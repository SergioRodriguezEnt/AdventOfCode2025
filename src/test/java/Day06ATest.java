import org.junit.jupiter.api.Test;
import software.aoc.day06.Operation;
import software.aoc.day06.OperationBuilder;
import software.aoc.day06.Operator;
import software.aoc.day06.Runner06;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06ATest {
    @Test
    public void test_operator() {
        assertThat(Operator.isOperator('+')).isTrue();
        assertThat(Operator.isOperator('-')).isFalse();
        assertThat(Operator.from("+")).isEqualTo(Operator.ADD);
        assertThat(Operator.ADD.identity()).isEqualTo(0);
        assertThat(Operator.ADD.apply(2L, 3L)).isEqualTo(5L);
    }

    @Test
    public void test_operation() {
        Operation add = new Operation(List.of(1L, 4L, 5L), Operator.ADD);
        Operation multiply = new Operation(List.of(1L, 2L, 5L), Operator.MULTIPLY);
        assertThat(add.operate()).isEqualTo(10);
        assertThat(multiply.operate()).isEqualTo(10);
    }

    @Test
    public void test_operation_builder_simple() {
        long[] results = new OperationBuilder().add(" 45 64  387 23").add("  6 98  215 314").add("*   +   *   +").buildSimple().mapToLong(Operation::operate).toArray();
        assertThat(results).isEqualTo(new long[] {270, 162, 83205, 337});
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner06.with(this.getClass().getResourceAsStream("Day06TestInput.txt"), Runner06.BuildingComplexity.SIMPLE)
                .run();
        assertThat(result).isEqualTo(4277556);
    }

}
