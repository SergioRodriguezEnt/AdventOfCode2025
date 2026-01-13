import org.junit.jupiter.api.Test;
import software.aoc.day09.Coordinate;
import software.aoc.day09.Rectangle;
import software.aoc.day09.Runner09;

import static org.assertj.core.api.Assertions.assertThat;


public class Day09ATest {
    @Test
    public void test_coordinate() {
        assertThat(Coordinate.from("9,10")).isEqualTo(new Coordinate(9, 10));
    }

    @Test
    public void test_rectangle() {
        Rectangle rectangle1 = new Rectangle(new Coordinate(9, 10), new Coordinate(0, 0));
        Rectangle rectangle2 = new Rectangle(new Coordinate(10, 10), new Coordinate(5, 20));
        assertThat(rectangle1.area()).isEqualTo(110);
        assertThat(rectangle1.overlaps(rectangle2)).isTrue();
        assertThat(rectangle2.contains(new Coordinate(6, 13))).isTrue();
    }

    @Test
    public void test_runner_with_inputs() {
        long result = Runner09.with(this.getClass().getResourceAsStream("Day09TestInput.txt"))
                .getArea();
        assertThat(result).isEqualTo(50);
    }


}
