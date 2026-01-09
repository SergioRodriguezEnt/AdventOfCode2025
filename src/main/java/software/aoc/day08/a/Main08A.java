package software.aoc.day08.a;

import software.aoc.day08.Runner08;

public class Main08A {
    static void main() {
        long result = Runner08.with(Main08A.class.getClassLoader().getResourceAsStream("Day08Input.txt"))
                .runFor(1000);
        System.out.println(result);
    }
}
