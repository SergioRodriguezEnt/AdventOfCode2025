package software.aoc.day06.a;

import software.aoc.day06.Runner06;

public class Main06A {
    static void main() {
        long result = Runner06.with(Main06A.class.getClassLoader().getResourceAsStream("Day06Input.txt"), Runner06.BuildingComplexity.SIMPLE)
                .run();
        System.out.println(result);
    }
}
