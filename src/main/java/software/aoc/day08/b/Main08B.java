package software.aoc.day08.b;

import software.aoc.day08.Runner08;

public class Main08B {
    static void main() {
        long result = Runner08.with(Main08B.class.getClassLoader().getResourceAsStream("Day08Input.txt"))
                .run();
        System.out.println(result);
    }
}
