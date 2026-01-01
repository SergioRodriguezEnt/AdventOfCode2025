import org.junit.jupiter.api.Test;
import software.aoc.day07.Runner07;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07BTest {
    @Test
    public void test() {
        long result = Runner07.with(this.getClass().getResourceAsStream("Day07TestInput.txt"))
                .getPaths();
        assertThat(result).isEqualTo(40);
    }
}
