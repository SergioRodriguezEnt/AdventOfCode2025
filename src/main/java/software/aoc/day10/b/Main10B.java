package software.aoc.day10.b;

import software.aoc.day10.Runner10;

public class Main10B {
    static void main() {
        long result = Runner10.with(Main10B.class.getClassLoader().getResourceAsStream("Day10Input.txt"))
                .runVoltageSolver();
        System.out.println(result);
    }
}
