package software.aoc.day06.b;

import software.aoc.day06.Runner06;

public class Main06B {
    static void main() {
        long result = Runner06.with(Main06B.class.getClassLoader().getResourceAsStream("Day06Input.txt"), new OperationBuilderB())
                .run();
        System.out.println(result);
    }
}
