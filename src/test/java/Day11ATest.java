import org.junit.jupiter.api.Test;
import software.aoc.day11.PathFinder;
import software.aoc.day11.Runner11;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day11ATest {
    @Test
    public void test_path_finder() {
        PathFinder finder = PathFinder.from(List.of(
                "aaa: you hhh",
                "you: bbb ccc",
                "ccc: ddd eee fff",
                "eee: out",
                "fff: out"));
        assertThat(finder.paths()).isEqualTo(2);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner11.with(this.getClass().getResourceAsStream("Day11ATestInput.txt"))
                .findNormalPaths();
        assertThat(result).isEqualTo(5);
    }

}
