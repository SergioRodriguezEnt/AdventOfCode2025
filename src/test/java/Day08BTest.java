import org.junit.jupiter.api.Test;
import software.aoc.day08.b.Runner08B;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08BTest {
    @Test
    public void test() {
        long result = Runner08B.with(this.getClass().getResourceAsStream("Day08TestInput.txt"))
                .run();
        assertThat(result).isEqualTo(25272);
    }
}
