import org.junit.jupiter.api.Test;
import software.aoc.Runner;
import software.aoc.day02.Runner02;
import software.aoc.day02.IdRange;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02ATest {
    LongPredicate condition = id -> !Long.toString(id).matches("^(\\d+)\\1$");

    @Test
    public void test_id_range_validation() {
        assertThat(new IdRange(11, 22).getIds().toArray()).isEqualTo(LongStream.range(11,23).toArray());
        assertThat(new IdRange(11, 22).getInvalidIds(condition).toArray()).isEqualTo(new long[]{11, 22});
        assertThat(new IdRange("11-22")).isEqualTo(new IdRange(11, 22));
    }

    @Test
    public void test_runner_should_execute_and_return_correctly() {
        Runner<Long> runner = new Runner02(condition);
        Long result = runner.runFrom(this.getClass().getResourceAsStream("Day02TestInput.txt"));
        assertThat(result).isEqualTo(1227775554);
    }
}
