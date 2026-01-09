import org.junit.jupiter.api.Test;
import software.aoc.day11.Runner11;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11ATest {
    @Test
    public void test() {
        long result = Runner11.with(this.getClass().getResourceAsStream("Day11ATestInput.txt"))
                .findNormalPaths();
        assertThat(result).isEqualTo(5);
    }

}
