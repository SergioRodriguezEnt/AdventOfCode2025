import org.junit.jupiter.api.Test;
import software.aoc.Runner;
import software.aoc.day01.b.Runner01B;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01BTest {
    @Test
    public void test_runner_should_execute_and_return_correctly() {
        Runner<Integer> runner = new Runner01B();
        Integer result = runner.runFrom(this.getClass().getResourceAsStream("Day01TestInput.txt"));
        assertThat(result).isEqualTo(6);
    }
}
