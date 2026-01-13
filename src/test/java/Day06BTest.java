import org.junit.jupiter.api.Test;
import software.aoc.day06.Operation;
import software.aoc.day06.OperationBuilder;
import software.aoc.day06.Runner06;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06BTest {
    @Test
    public void test_operation_builder_complex() {
        long[] results = new OperationBuilder().add("45 64 387 23").add(" 6 98 215 314").add("*  +  *   +").buildComplex().mapToLong(Operation::operate).toArray();
        assertThat(results).isEqualTo(new long[] {224, 117, 194400, 58});
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner06.with(this.getClass().getResourceAsStream("Day06TestInput.txt"), Runner06.BuildingComplexity.COMPLEX)
                .run();
        assertThat(result).isEqualTo(3263827);
    }
}
