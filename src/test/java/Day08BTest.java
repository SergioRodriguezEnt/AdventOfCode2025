import org.junit.jupiter.api.Test;
import software.aoc.day08.CircuitConnector;
import software.aoc.day08.CircuitLoader;
import software.aoc.day08.Runner08;

import static org.assertj.core.api.Assertions.assertThat;

public class Day08BTest {
    @Test
    public void test_circuit_connector_unlimited() {
        CircuitConnector connector = new CircuitConnector(new CircuitLoader().add("162,817,812").add("57,618,57").add("906,360,560").add("592,479,940").loadAll());
        assertThat(connector.connectionCost()).isEqualTo(9234);
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner08.with(this.getClass().getResourceAsStream("Day08TestInput.txt"))
                .run();
        assertThat(result).isEqualTo(25272);
    }
}
