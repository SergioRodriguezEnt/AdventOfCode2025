import org.junit.jupiter.api.Test;
import software.aoc.day11.Runner11;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11BTest
{
    @Test
    public void test() {
        long result = Runner11.with(this.getClass().getResourceAsStream("Day11BTestInput.txt"))
                .findServerPaths();
        assertThat(result).isEqualTo(2);
    }
}
