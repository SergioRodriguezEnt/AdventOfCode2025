package software.aoc.day01;

import java.util.function.ToIntBiFunction;

public record Lock(Dial dial, int count, ToIntBiFunction<Lock, Order> counterFn) {
    public Lock nextWith(Order order) {
        return new Lock(order.applyTo(dial), counterFn.applyAsInt(this, order), counterFn);
    }
}
