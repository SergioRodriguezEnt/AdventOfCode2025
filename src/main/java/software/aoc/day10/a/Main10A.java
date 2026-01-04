package software.aoc.day10.a;

import software.aoc.day10.Runner10;

public class Main10A {
    static void main() {
        long result = Runner10.with(Main10A.class.getClassLoader().getResourceAsStream("Day10Input.txt"))
                .run();
        System.out.println(result);
    }
}
