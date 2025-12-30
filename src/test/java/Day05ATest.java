import org.junit.jupiter.api.Test;
import software.aoc.day05.IdChecker;
import software.aoc.day05.IdRange;
import software.aoc.day05.Runner05;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05ATest {
    @Test
    public void test_id_range() {
        IdRange range = new IdRange("3-5");
        assertThat(range.contains(3)).isTrue();
        assertThat(range.overlapsWith(new IdRange("1-5"))).isTrue();
        assertThat(range.combineWith(new IdRange("1-3")).contains(2)).isTrue();
    }

    @Test
    public void test_id_checker() {
        IdChecker idChecker = new IdChecker();
        idChecker = idChecker.add("3-5").add("10-14").add("16-20").add("13-15");
        assertThat(idChecker.contains(3)).isTrue();
        assertThat(idChecker.contains(10)).isTrue();
        assertThat(idChecker.contains(15)).isTrue();
        assertThat(idChecker.contains(16)).isTrue();
        assertThat(idChecker.ranges().size()).isEqualTo(3);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner05.from(this.getClass().getResourceAsStream("Day05TestInput.txt"))
                .filter_ingredients();
        assertThat(result).isEqualTo(3);
    }
}
