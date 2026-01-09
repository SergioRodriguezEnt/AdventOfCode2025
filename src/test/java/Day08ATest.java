import org.junit.jupiter.api.Test;
import software.aoc.day08.Runner08;

import static org.assertj.core.api.Assertions.assertThat;


public class Day08ATest {
    @Test
    public void test() {
        long result = Runner08.with(this.getClass().getResourceAsStream("Day08TestInput.txt"))
                .runFor(10);
        assertThat(result).isEqualTo(40);
    }

}
