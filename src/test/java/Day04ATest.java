import org.junit.jupiter.api.Test;
import software.aoc.day04.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day04ATest {
    @Test
    public void test_space() {
        Space roll = Space.from('@');
        Space empty = Space.from('.');
        assertThat(roll).isEqualTo(Space.PAPER);
        assertThat(empty).isEqualTo(Space.EMPTY);
    }

    @Test
    public void test_position() {
        Position pos = new Position(1, 1);
        assertThat(pos.neighborRanges().toList().getFirst()).isEqualTo(new Position(0, 0));
    }

    @Test
    public void test_wall() {
        Wall wall = Wall.from(List.of("...", ".@.", "..."));
        assertThat(wall.spaceAt(new Position(1, 1))).isEqualTo(Space.PAPER);
    }

    @Test
    public void test_wall_analyzer() {
        Wall wall = Wall.from(List.of(".@.", "@@@", ".@."));
        WallAnalyzer analyzer = new WallAnalyzer(wall);
        assertThat(analyzer.getRemovableRollCount()).isEqualTo(4);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = new Runner04Factory()
                .from(this.getClass().getResourceAsStream("Day04TestInput.txt"))
                .type(Runner04Factory.Runner04Type.A)
                .runner()
                .run();
        assertThat(result).isEqualTo(13);
    }

}
