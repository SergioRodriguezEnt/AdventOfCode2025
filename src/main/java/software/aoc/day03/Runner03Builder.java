package software.aoc.day03;

import java.io.InputStream;

public class Runner03Builder {
    private InputStream file;
    private int maxBatteriesActivePerBank;
    
    public Runner03Builder from(InputStream file) {
        this.file = file;
        return this;
    }
    
    public Runner03Builder with(int maxBatteriesActivePerBank) {
        this.maxBatteriesActivePerBank = maxBatteriesActivePerBank;
        return this;
    }
    
    public Runner03 runner() {
        return new Runner03(file, maxBatteriesActivePerBank);
    }
}
