package software.aoc.day11.a;

import software.aoc.day11.Runner11;

public class Main11A {
    static void main() {
        long result = Runner11.with(Main11A.class.getClassLoader().getResourceAsStream("Day11Input.txt"))
                .run();
        System.out.println(result);
    }
}
