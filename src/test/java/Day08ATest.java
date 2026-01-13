import org.junit.jupiter.api.Test;
import software.aoc.day08.*;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class Day08ATest {
    @Test
    public void test_box() {
        assertThat(new Box(0, 0, 0).distanceTo(new Box(1, 1, 1))).isEqualTo(Math.sqrt(3));
    }

    @Test
    public void test_circuit_loader() {
        List<Circuit> circuits = new CircuitLoader().add("162,817,812").add("57,618,57").loadAll();
        assertThat(circuits).isEqualTo(List.of(new Circuit(Set.of(new Box(162, 817, 812))), new Circuit(Set.of(new Box(57,618,57)))));
    }

    @Test
    public void test_circuit_connector_limited() {
        CircuitConnector connector = new CircuitConnector(new CircuitLoader().add("162,817,812").add("57,618,57").add("906,360,560").add("592,479,940").loadAll());
        assertThat(connector.connectionCostFor(1)).isEqualTo(2);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner08.with(this.getClass().getResourceAsStream("Day08TestInput.txt"))
                .runFor(10);
        assertThat(result).isEqualTo(40);
    }

}
