package software.aoc.day07.a;

import software.aoc.day07.Runner07;

public class Main07A {
    static void main() {
        int result = Runner07.with(Main07A.class.getClassLoader().getResourceAsStream("Day07Input.txt"))
                .getSplits();
        System.out.println(result);
    }
}
