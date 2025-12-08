package software.aoc.day03.b;

import software.aoc.Runner;

public class Main03B {
    static void main() {
        Runner<Integer> runner = new Runner03B();
        System.out.println(runner.runFrom(Main03B.class.getClassLoader().getResourceAsStream("Day03Input.txt")));
    }
}
