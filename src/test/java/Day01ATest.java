import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01ATest {
    @Test
    public void test() {
        Dial dial = new Dial();
        assertThat(dial.position()).isEqualTo(50);
    }

    private class Dial {
        public int position() {
            return 50;
        }
    }
}
