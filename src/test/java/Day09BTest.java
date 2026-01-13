import org.junit.jupiter.api.Test;
import software.aoc.day09.Runner09;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09BTest {
    @Test
    public void test_runner_with_inputs() {
        long result = Runner09.with(this.getClass().getResourceAsStream("Day09TestInput.txt"))
                .getAllowedArea();
        assertThat(result).isEqualTo(24);
    }
}
