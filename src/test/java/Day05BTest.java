import org.junit.jupiter.api.Test;
import software.aoc.day05.Runner05;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05BTest {
    @Test
    public void test_runner_with_inputs() {
        long result = Runner05.from(this.getClass().getResourceAsStream("Day05TestInput.txt"))
                .count_possible_ingredients();
        assertThat(result).isEqualTo(14);
    }
}
