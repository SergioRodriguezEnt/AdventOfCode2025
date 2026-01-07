package software.aoc.day12.a;

import software.aoc.day12.Runner12;

public class Main12A {
    static void main() {
        long result = Runner12.with(Main12A.class.getClassLoader().getResourceAsStream("Day12Input.txt"))
                .run();
        System.out.println(result);
    }
}
