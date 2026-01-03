import org.junit.jupiter.api.Test;
import software.aoc.day09.Runner09;

import static org.assertj.core.api.Assertions.assertThat;

public class Day09BTest {
    @Test
    public void test() {
        long result = Runner09.with(this.getClass().getResourceAsStream("Day09TestInput.txt"))
                .getAllowedArea();
        assertThat(result).isEqualTo(24);
    }
}
