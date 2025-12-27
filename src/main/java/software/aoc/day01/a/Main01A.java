package software.aoc.day01.a;

import software.aoc.day01.Lock;
import software.aoc.day01.Order;
import software.aoc.day01.Runner01Builder;

public class Main01A {

    static void main() {
        int result = new Runner01Builder()
                .from(Main01A.class.getClassLoader().getResourceAsStream("Day01Input.txt"))
                .use(Main01A::counter)
                .runner()
                .run();
        System.out.println(result);
    }

    public static int counter(Lock lock, Order order) {
        return lock.count() + (lock.updateDialWith(order).position() == 0 ? 1 : 0);
    }
}