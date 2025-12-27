package software.aoc.day01;

import java.util.function.ToIntBiFunction;

public record Lock(Dial dial, int count, ToIntBiFunction<Lock, Order> counter) {
    public Lock nextFrom(Order order) {
        return new Lock(updateDialWith(order), counter.applyAsInt(this, order), counter);
    }

    public Dial updateDialWith(Order order) {
        return new Dial(dial.position() + order.rotation());
    }
}
