package software.aoc.day01.b;


import software.aoc.day01.Lock;
import software.aoc.day01.Order;
import software.aoc.day01.Runner01Builder;

public class Main01B {
    static void main() {
        int result = new Runner01Builder()
                .from(Main01B.class.getClassLoader().getResourceAsStream("Day01Input.txt"))
                .use(Main01B::counterFn)
                .runner()
                .run();
        System.out.println(result);
    }

    private static int counterFn(Lock lock, Order order) {
        return lock.count()
                + fullRotations(order)
                + remainderCrosses(lock.dial().position(), order.rotation()%100, order.applyTo(lock.dial()).position());
    }

    private static int fullRotations(Order order) {
        return order.amount() / 100;
    }

    private static int remainderCrosses(int oldPosition, int remainderRotation, int newPosition) {
        if (remainderRotation == 0 || oldPosition == 0) return 0;
        if (remainderRotation > 0 && newPosition < oldPosition) return 1;
        if (remainderRotation < 0 && newPosition > oldPosition) return 1;
        if (newPosition == 0) return 1;
        return 0;
    }
}
