import org.junit.jupiter.api.Test;
import software.aoc.day02.IdRange;
import software.aoc.day02.Runner02Builder;
import software.aoc.day02.a.Main02A;

import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02ATest {
    @Test
    public void test_id_range_with_condition() {
        assertThat(new IdRange(11, 22).getIds().toArray()).isEqualTo(LongStream.range(11,23).toArray());
        assertThat(new IdRange(11, 22).getInvalidIds(Main02A::validator).toArray()).isEqualTo(new long[]{11, 22});
        assertThat(new IdRange("11-22")).isEqualTo(new IdRange(11, 22));
    }

    @Test
    public void test_runner_with_inputs() {
        long result = new Runner02Builder()
                .from(this.getClass().getResourceAsStream("Day02TestInput.txt"))
                .use(Main02A::validator)
                .runner()
                .run();
        assertThat(result).isEqualTo(1227775554);
    }
}
