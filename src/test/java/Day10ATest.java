import org.junit.jupiter.api.Test;

import software.aoc.day10.Button;
import software.aoc.day10.Indicator;
import software.aoc.day10.Machine;
import software.aoc.day10.Runner10;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10ATest {
    @Test
    public void test_button() {
        assertThat(Button.from("(0,1,2,3,5)")).isEqualTo(new Button(Set.of(0, 1, 2, 3, 5)));
    }

    @Test
    public void test_indicator() {
        assertThat(Indicator.from("[.##.]", "{3,5,4,7}"))
                .isEqualTo(new Indicator(List.of(
                        Indicator.State.OF,
                        Indicator.State.ON,
                        Indicator.State.ON,
                        Indicator.State.OF),
                        List.of(3, 5, 4, 7)));
        Indicator indicator1 = Indicator.from("[.##.]", "{3,5,4,7}");
        Indicator indicator2 = Indicator.from("[.##.]", "{1,1,0,1}");
        assertThat(indicator1.reduceVoltagesWith(indicator2).halfVoltages().voltages())
                .isEqualTo(List.of(1, 2, 2, 3));
        assertThat(indicator1.switchState(0)).isEqualTo(Indicator.State.ON);
    }

    @Test
    public void test_machine_state_solver() {
        assertThat(Machine.from("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}").solveDesiredState())
                .isEqualTo(2);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner10.with(this.getClass().getResourceAsStream("Day10TestInput.txt"))
                .runStateSolver();
        assertThat(result).isEqualTo(7);
    }

}
