import org.junit.jupiter.api.Test;
import software.aoc.day02.IdRange;
import software.aoc.day02.Runner02Builder;
import software.aoc.day02.b.Main02B;

import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02BTest {
    @Test
    public void test_id_range_with_condition() {
        assertThat(new IdRange(99, 111).getIds().toArray()).isEqualTo(LongStream.range(99,112).toArray());
        assertThat(new IdRange(99, 111).getInvalidIds(Main02B::validator).toArray()).isEqualTo(new long[]{99, 111});
        assertThat(new IdRange("99-111")).isEqualTo(new IdRange(99, 111));
    }

    @Test
    public void test_runner_with_inputs() {
        long result = new Runner02Builder()
                .from(this.getClass().getResourceAsStream("Day02TestInput.txt"))
                .use(Main02B::validator)
                .runner()
                .run();
        assertThat(result).isEqualTo(4174379265L);
    }
}
