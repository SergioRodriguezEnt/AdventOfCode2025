import org.junit.jupiter.api.Test;
import software.aoc.Runner;
import software.aoc.day01.a.Day01ARunner;
import software.aoc.day01.a.Dial;
import software.aoc.day01.a.Order;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {
    @Test
    public void test_dial_is_immutable_and_executes_orders() {
        Dial dial = new Dial();
        assertThat(dial.position()).isEqualTo(50);
        Dial dial2 = new Order("L68").apply(dial);
        assertThat(dial2).isNotEqualTo(dial);
        assertThat(dial2.position()).isEqualTo(82);
        assertThat(new Order("R168").apply(dial2).position()).isEqualTo(50);
    }

    @Test
    public void test_runner_should_execute_and_return_correctly() {
        Runner<Integer> runner = new Day01ARunner();
        Integer result = runner.runFrom(this.getClass().getResourceAsStream("Day01ATestInput.txt"));
        assertThat(result).isEqualTo(3);
    }

}
