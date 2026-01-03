package software.aoc.day09.a;

import software.aoc.day09.Runner09;

public class Main09A {
    static void main() {
        long result = Runner09.with(Main09A.class.getClassLoader().getResourceAsStream("Day09Input.txt"))
                .getArea();
        System.out.println(result);
    }
}
