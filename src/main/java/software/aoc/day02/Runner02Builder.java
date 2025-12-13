package software.aoc.day02;

import java.io.InputStream;
import java.util.function.LongPredicate;

public class Runner02Builder {
    private InputStream fileStream;
    private LongPredicate validationCondition;
    
    public Runner02Builder from(InputStream fileStream) {
        this.fileStream = fileStream;
        return this;
    }
    
    public Runner02Builder use(LongPredicate validationCondition) {
        this.validationCondition = validationCondition;
        return this;
    }
    
    public Runner02 runner() {
        return new Runner02(fileStream, validationCondition);
    }
}
