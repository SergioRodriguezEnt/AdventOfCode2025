import org.junit.jupiter.api.Test;
import software.aoc.day06.Operation;
import software.aoc.day06.Runner06;
import software.aoc.day06.b.OperationBuilderB;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06BTest {
    @Test
    public void test_operation_builder() {
        long[] results = new OperationBuilderB().add("45 64 387 23").add(" 6 98 215 314").add("*  +  *   +").build().mapToLong(Operation::operate).toArray();
        assertThat(results).isEqualTo(new long[] {224, 117, 194400, 58});
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner06.with(this.getClass().getResourceAsStream("Day06TestInput.txt"), new OperationBuilderB())
                .run();
        assertThat(result).isEqualTo(3263827);
    }
}
