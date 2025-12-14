package software.aoc.day03.b;

import software.aoc.day03.Runner03Builder;

public class Main03B {
    static void main() {
        long result = new Runner03Builder()
                .from(Main03B.class.getClassLoader().getResourceAsStream("Day03Input.txt"))
                .with(12)
                .runner()
                .run();
        System.out.println(result);
    }
}
