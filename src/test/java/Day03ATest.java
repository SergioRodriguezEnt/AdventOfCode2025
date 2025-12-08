import org.junit.jupiter.api.Test;
import software.aoc.Runner;
import software.aoc.day03.Bank;
import software.aoc.day03.a.Runner03A;

import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03ATest {
    @Test
    public void test_bank_stores_correctly() {
        Bank bank = new Bank("987654321111111");
        assertThat(bank.batteries()).isEqualTo(new int[]{9,8,7,6,5,4,3,2,1,1,1,1,1,1,1});
        assertThat(bank.batteryStream().max()).isEqualTo(OptionalInt.of(9));
        assertThat(bank.batteryStream().min()).isEqualTo(OptionalInt.of(1));
    }

    @Test
    public void test_runner_should_execute_and_return_correctly() {
        Runner<Integer> runner = new Runner03A();
        assertThat(runner.runFrom(this.getClass().getResourceAsStream("Day03TestInput.txt"))).isEqualTo(357);
    }
}
