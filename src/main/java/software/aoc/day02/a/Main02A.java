package software.aoc.day02.a;

import software.aoc.Runner;
import software.aoc.day02.Runner02;

import java.util.function.LongPredicate;

public class Main02A {
    static final LongPredicate condition = id -> !Long.toString(id).matches("^(\\d+)\\1$");

    static void main() {
        Runner<Long> runner = new Runner02(condition);
        System.out.println(runner.runFrom(Main02A.class.getClassLoader().getResourceAsStream("Day02Input.txt")));
    }
}
