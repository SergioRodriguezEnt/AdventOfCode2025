package software.aoc.day02;

import java.io.InputStream;
import java.util.function.LongPredicate;

public class Runner02Builder {
    private InputStream file;
    private LongPredicate validator;
    
    public Runner02Builder from(InputStream file) {
        this.file = file;
        return this;
    }
    
    public Runner02Builder use(LongPredicate validator) {
        this.validator = validator;
        return this;
    }
    
    public Runner02 runner() {
        return new Runner02(file, validator);
    }
}
