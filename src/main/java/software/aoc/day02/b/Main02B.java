package software.aoc.day02.b;

import software.aoc.day02.Runner02Builder;

public class Main02B {
    static void main() {
        long result = new Runner02Builder()
                .from(Main02B.class.getClassLoader().getResourceAsStream("Day02Input.txt"))
                .use(Main02B::validator)
                .runner()
                .run();
        System.out.println(result);
    }

    private static boolean validator(long id) {
        return !Long.toString(id).matches("^(\\d+)\\1+$");
    }
}
