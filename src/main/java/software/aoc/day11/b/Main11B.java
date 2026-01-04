package software.aoc.day11.b;

import software.aoc.day11.Runner11;

public class Main11B {
    static void main() {
        long result = Runner11.with(Main11B.class.getClassLoader().getResourceAsStream("Day11Input.txt"))
                .runB();
        System.out.println(result);
    }
}
