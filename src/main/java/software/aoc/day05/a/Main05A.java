package software.aoc.day05.a;

import software.aoc.day05.Runner05;

public class Main05A {
    static void main() {
        long result = Runner05.from(Main05A.class.getClassLoader().getResourceAsStream("Day05Input.txt"))
                .filter_ingredients();
        System.out.println(result);
    }
}
