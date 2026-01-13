import org.junit.jupiter.api.Test;
import software.aoc.day12.Combinator;
import software.aoc.day12.Present;
import software.aoc.day12.Region;
import software.aoc.day12.Runner12;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day12ATest {
    @Test
    public void test_present() {
        Present present = Present.from(List.of("0: ",
                "###",
                "##.",
                "##."));
        Present flipped = Present.from(List.of("0: ",
                "###",
                ".##",
                ".##"));
        assertThat(present.area()).isEqualTo(7);
        assertThat(present.flippedHorizontal().coordinates().containsAll(flipped.coordinates())).isTrue();
    }

    @Test
    public void test_region() {
        Region region = Region.from("4x4: 0 0 0 0 2 0");
        assertThat(region.totalPresents()).isEqualTo(2);
        assertThat(region.area()).isEqualTo(16);
    }

    @Test
    public void test_combinator() {
        List<Integer> ints = List.of(1, 2, 3, 4);
        assertThat(Combinator.combinations(ints, 2).toList()).isEqualTo(List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 3),
                List.of(2, 4),
                List.of(3, 4)
        ));
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner12.with(this.getClass().getResourceAsStream("Day12TestInput.txt"))
                .run();
        assertThat(result).isEqualTo(2L);
    }
}
