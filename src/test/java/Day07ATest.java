import org.junit.jupiter.api.Test;
import software.aoc.day07.Cell;
import software.aoc.day07.GridBuilder;
import software.aoc.day07.GridUpdater;
import software.aoc.day07.Runner07;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day07ATest {
    @Test
    public void test_cell() {
        assertThat(Cell.from('.')).isEqualTo(Cell.empty());
        assertThat(Cell.newBeam()).isEqualTo(Cell.beam(1));
        assertThat(Cell.parse(".^.|")).isEqualTo(List.of(Cell.empty(), Cell.splitter(), Cell.empty(), Cell.newBeam()));
    }

    @Test
    public void test_grid_builder() {
        assertThat(new GridBuilder().add(".^.|").build().getFirst()).isEqualTo(List.of(Cell.empty(), Cell.splitter(), Cell.empty(), Cell.newBeam()));
    }

    @Test
    public void test_grid_updater() {
        GridUpdater updater = new GridUpdater(new GridBuilder().add(".|||.").add("...^.").add(".....").build(), 0, 1).resolve();
        assertThat(updater.grid().getLast()).isEqualTo(List.of(Cell.empty(), Cell.newBeam(), Cell.beam(2), Cell.empty(), Cell.newBeam()));
        assertThat(updater.count()).isEqualTo(1);
    }

    @Test
    public void test_runner_with_inputs() {
        int result = Runner07.with(this.getClass().getResourceAsStream("Day07TestInput.txt"))
                .getSplits();
        assertThat(result).isEqualTo(21);
    }
}
