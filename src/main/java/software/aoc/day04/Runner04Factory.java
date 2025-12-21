package software.aoc.day04;

import software.aoc.day04.a.Runner04A;
import software.aoc.day04.b.Runner04B;

import java.io.InputStream;

public class Runner04Factory {
    private InputStream file;
    private Runner04Type type;

    public Runner04Factory from(InputStream file) {
        this.file = file;
        return this;
    }

    public Runner04Factory type(Runner04Type type) {
        this.type = type;
        return this;
    }

    public Runner04 runner() {
        if (type == Runner04Type.A) return new Runner04A(file);
        return new Runner04B(file);
    }

    public enum Runner04Type {A, B}
}
