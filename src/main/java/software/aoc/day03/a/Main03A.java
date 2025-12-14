package software.aoc.day03.a;

import software.aoc.day03.Runner03Builder;

public class Main03A {
    static void main() {
        long result = new Runner03Builder()
                .from(Main03A.class.getClassLoader().getResourceAsStream("Day03Input.txt"))
                .with(2)
                .runner()
                .run();
        System.out.println(result);
    }
}
