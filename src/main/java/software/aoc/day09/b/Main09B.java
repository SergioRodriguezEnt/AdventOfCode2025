package software.aoc.day09.b;

import software.aoc.day09.Runner09;

public class Main09B {
    static void main() {
        long result = Runner09.with(Main09B.class.getClassLoader().getResourceAsStream("Day09Input.txt"))
                .getAllowedArea();
        System.out.println(result);
    }
}
