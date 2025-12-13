package software.aoc.day01;

import java.io.InputStream;
import java.util.function.ToIntBiFunction;

public class Runner01Builder {
    private InputStream fileStream;
    private ToIntBiFunction<Lock, Order> counterFn;

    public Runner01Builder from(InputStream fileStream) {
        this.fileStream = fileStream;
        return this;
    }

    public Runner01Builder use(ToIntBiFunction<Lock, Order> counterFn) {
        this.counterFn = counterFn;
        return this;
    }

    public Runner01 runner() {
        return new Runner01(fileStream, counterFn);
    }
}
