import org.junit.jupiter.api.Test;
import software.aoc.day10.Machine;
import software.aoc.day10.Runner10;

import static org.assertj.core.api.Assertions.assertThat;

public class Day10BTest {
    @Test
    public void test_machine_voltage_solver() {
        assertThat(Machine.from("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}").solveVoltageRequirements())
                .isEqualTo(10);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner10.with(this.getClass().getResourceAsStream("Day10TestInput.txt"))
                .runVoltageSolver();
        assertThat(result).isEqualTo(33);
    }
}
