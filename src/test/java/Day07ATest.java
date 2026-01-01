import org.junit.jupiter.api.Test;
import software.aoc.day07.Runner07;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07ATest {
    @Test
    public void test() {
        int result = Runner07.with(this.getClass().getResourceAsStream("Day07TestInput.txt"))
                .getSplits();
        assertThat(result).isEqualTo(21);
    }
}
