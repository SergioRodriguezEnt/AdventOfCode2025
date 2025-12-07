package software.aoc.day01.a;

import software.aoc.Runner;

public class Main01A {
    static void main() {
        Runner<Integer> runner = new Runner01A();
        System.out.println(runner.runFrom(Main01A.class.getClassLoader().getResourceAsStream("Day01Input.txt")));
    }
}