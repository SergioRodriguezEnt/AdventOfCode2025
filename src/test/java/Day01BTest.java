import org.junit.jupiter.api.Test;
import software.aoc.day01.Dial;
import software.aoc.day01.Lock;
import software.aoc.day01.Order;
import software.aoc.day01.Runner01Builder;
import software.aoc.day01.b.Main01B;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01BTest {
    @Test
    public void test_lock_counts_positions_pass_through_zero() {
        Lock lock1 = new Lock(new Dial(), 0, Main01B::counter);
        Order order1 = new Order("L60");
        Lock lock2 = lock1.nextFrom(order1);
        Order order2 = new Order("R10");
        Lock lock3 = lock2.nextFrom(order2);

        assertThat(lock2.count()).isEqualTo(1);
        assertThat(lock3.count()).isEqualTo(2);
    }

    @Test
    public void test_runner_with_inputs() {
        int result = new Runner01Builder()
                .from(this.getClass().getResourceAsStream("Day01TestInput.txt"))
                .use(Main01B::counter)
                .runner()
                .run();
        assertThat(result).isEqualTo(6);
    }
}
