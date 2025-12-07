package software.aoc;

import java.io.InputStream;

public interface Runner<T> {
    T runFrom(InputStream file);
}
