import org.junit.jupiter.api.Test;
import software.aoc.day03.DigitSequenceSelector;
import software.aoc.day03.Runner03Builder;

import static org.assertj.core.api.Assertions.assertThat;

public class Day03BTest {@Test
public void test_digit_sequence_selector_with_4_digits() {
    long number = new DigitSequenceSelector(4)
            .continueWith(1)
            .continueWith(8)
            .continueWith(1)
            .continueWith(7)
            .continueWith(9)
            .continueWith(3)
            .number();
    assertThat(number).isEqualTo(8793);
}

    @Test
    public void test_runner_with_inputs() {
        long result = new Runner03Builder()
                .from(this.getClass().getResourceAsStream("Day03TestInput.txt"))
                .with(12)
                .runner()
                .run();
        assertThat(result).isEqualTo(3121910778619L);
    }
}
