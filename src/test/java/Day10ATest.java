import org.junit.jupiter.api.Test;

import software.aoc.day10.Runner10;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10ATest {
    @Test
    public void test() {
        long result = Runner10.with(this.getClass().getResourceAsStream("Day10TestInput.txt"))
                .run();
        assertThat(result).isEqualTo(7);
    }

}
