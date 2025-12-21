import org.junit.jupiter.api.Test;
import software.aoc.day04.Runner04Factory;
import software.aoc.day04.Wall;
import software.aoc.day04.WallAnalyzer;
import software.aoc.day04.b.WallRemover;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04BTest {
    @Test
    public void test_wall_remover() {
        Wall wall = Wall.from(List.of(".@.", "@@@", ".@."));
        WallAnalyzer analyzer = new WallAnalyzer(wall);
        Wall wall2 = new WallRemover(wall).removePositions(analyzer.getRemovableRolls()).wall();
        WallAnalyzer analyzer2 = new WallAnalyzer(wall2);
        assertThat(analyzer2.getRemovableRollCount()).isEqualTo(1);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = new Runner04Factory()
                .from(this.getClass().getResourceAsStream("Day04TestInput.txt"))
                .type(Runner04Factory.Runner04Type.B)
                .runner()
                .run();
        assertThat(result).isEqualTo(43);
    }
}
