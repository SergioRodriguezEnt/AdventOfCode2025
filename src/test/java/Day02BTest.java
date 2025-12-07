import org.junit.jupiter.api.Test;
import software.aoc.Runner;
import software.aoc.day02.Runner02;

import java.util.function.LongPredicate;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02BTest {
    LongPredicate condition = id -> !Long.toString(id).matches("^(\\d+)\\1+$");

    @Test
    public void test_runner_should_execute_and_return_correctly() {
        Runner<Long> runner = new Runner02(condition);
        Long result = runner.runFrom(this.getClass().getResourceAsStream("Day02TestInput.txt"));
        assertThat(result).isEqualTo(4174379265L);
    }
}
