package software.aoc.day03.a;

import software.aoc.Runner;

public class Main03A {
    static void main() {
        Runner<Integer> runner = new Runner03A();
        System.out.println(runner.runFrom(Main03A.class.getClassLoader().getResourceAsStream("Day03Input.txt")));
    }
}
