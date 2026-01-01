import org.junit.jupiter.api.Test;
import software.aoc.day08.a.Runner08A;

import static org.assertj.core.api.Assertions.assertThat;


public class Day08ATest {
    @Test
    public void test() {
        long result = Runner08A.with(this.getClass().getResourceAsStream("Day08TestInput.txt"))
                .run(10);
        assertThat(result).isEqualTo(40);
    }

}
