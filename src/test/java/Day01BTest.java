import org.junit.jupiter.api.Test;
import software.aoc.day01.Dial;
import software.aoc.day01.Lock;
import software.aoc.day01.Order;
import software.aoc.day01.Runner01Builder;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01BTest {

    private static int counterFn(Lock lock, Order order) {
        return lock.count()
                + fullRotations(order)
                + remainderCrosses(lock.dial().position(), order.rotation()%100, order.applyTo(lock.dial()).position());
    }

    private static int fullRotations(Order order) {
        return order.amount() / 100;
    }

    private static int remainderCrosses(int oldPosition, int remainderRotation, int newPosition) {
        if (remainderRotation == 0 || oldPosition == 0) return 0;
        if (remainderRotation > 0 && newPosition < oldPosition) return 1;
        if (remainderRotation < 0 && newPosition > oldPosition) return 1;
        if (newPosition == 0) return 1;
        return 0;
    }

    @Test
    public void test_lock_counts_positions_pass_through_zero() {
        Lock lock1 = new Lock(new Dial(), 0, Day01BTest::counterFn);
        Order order1 = new Order("L60");
        Lock lock2 = lock1.nextWith(order1);
        Order order2 = new Order("R10");
        Lock lock3 = lock2.nextWith(order2);

        assertThat(lock2.count()).isEqualTo(1);
        assertThat(lock3.count()).isEqualTo(2);
    }

    @Test
    public void test_runner_with_inputs() {
        int result = new Runner01Builder()
                .from(this.getClass().getResourceAsStream("Day01TestInput.txt"))
                .use(Day01BTest::counterFn)
                .runner()
                .run();
        assertThat(result).isEqualTo(6);
    }
}
