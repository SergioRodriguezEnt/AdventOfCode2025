package software.aoc.day05.b;

import software.aoc.day05.Runner05;

public class Main05B {
    static void main() {
        long result = Runner05.from(Main05B.class.getClassLoader().getResourceAsStream("Day05Input.txt"))
                .count_possible_ingredients();
        System.out.println(result);
    }
}
