import org.junit.jupiter.api.Test;
import software.aoc.day01.Lock;
import software.aoc.day01.Runner01Builder;
import software.aoc.day01.Dial;
import software.aoc.day01.Order;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {
    @Test
    public void test_dial() {
        Dial dial1 = new Dial();
        Dial dial2 = new Dial(120);
        Dial dial3 = new Dial(-120);

        assertThat(dial1.position()).isEqualTo(50);
        assertThat(dial2.position()).isEqualTo(20);
        assertThat(dial3.position()).isEqualTo(80);
    }

    @Test
    public void test_order() {
        Dial dial = new Dial();
        Order order1 = new Order("L10");
        Order order2 = new Order("R10");

        assertThat(order1.sign()).isEqualTo(-1);
        assertThat(order1.amount()).isEqualTo(10);
        assertThat(order1.rotation()).isEqualTo(-10);
        assertThat(order1.apply(dial).position()).isEqualTo(40);

        assertThat(order2.sign()).isEqualTo(1);
        assertThat(order2.amount()).isEqualTo(10);
        assertThat(order2.rotation()).isEqualTo(10);
        assertThat(order2.apply(dial).position()).isEqualTo(60);
    }

    private static int counterFn(Lock lock, Order order) {
        return lock.count() + (order.apply(lock.dial()).position() == 0 ? 1 : 0);
    }

    @Test
    public void test_lock_counts_positions_equaling_zero() {
        Lock lock1 = new Lock(new Dial(), 0, Day01ATest::counterFn);
        Order order1 = new Order("L60");
        Lock lock2 = lock1.nextWith(order1);
        Order order2 = new Order("R10");
        Lock lock3 = lock2.nextWith(order2);

        assertThat(lock2.count()).isEqualTo(0);
        assertThat(lock3.count()).isEqualTo(1);
    }

    @Test
    public void test_runner_with_inputs() {
        int result = new Runner01Builder()
                .from(this.getClass().getResourceAsStream("Day01TestInput.txt"))
                .use(Day01ATest::counterFn)
                .runner()
                .run();
        assertThat(result).isEqualTo(3);
    }
}
