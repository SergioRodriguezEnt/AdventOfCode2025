import org.junit.jupiter.api.Test;
import software.aoc.day12.Runner12;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12ATest {
    @Test
    public void test() {
        long result = Runner12.with(this.getClass().getResourceAsStream("Day12TestInput.txt"))
                .run();
        assertThat(result).isEqualTo(3L);
    }

}
