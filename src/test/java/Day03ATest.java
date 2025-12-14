import org.junit.jupiter.api.Test;
import software.aoc.day03.Bank;
import software.aoc.day03.DigitSequenceSelector;
import software.aoc.day03.Runner03Builder;

import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03ATest {
    @Test
    public void test_bank() {
        Bank bank = new Bank("987654321111111");
        assertThat(bank.batteries()).isEqualTo(new int[]{9,8,7,6,5,4,3,2,1,1,1,1,1,1,1});
        assertThat(bank.batteryStream().max()).isEqualTo(OptionalInt.of(9));
        assertThat(bank.batteryStream().min()).isEqualTo(OptionalInt.of(1));
    }

    @Test
    public void test_digit_sequence_selector_with_2_digits() {
        long number = new DigitSequenceSelector(2)
                .continueWith(9)
                .continueWith(8)
                .continueWith(9)
                .number();
        assertThat(number).isEqualTo(99);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = new Runner03Builder()
                .from(this.getClass().getResourceAsStream("Day03TestInput.txt"))
                .with(2)
                .runner()
                .run();
        assertThat(result).isEqualTo(357);
    }
}
