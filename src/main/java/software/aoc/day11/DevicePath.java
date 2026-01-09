package software.aoc.day11;

import java.util.HashSet;
import java.util.Set;

public record DevicePath(String device, Set<String> path) {
    public DevicePath continueWith(String nextDevice) {
        Set<String> newPath = new HashSet<>(path);
        newPath.add(nextDevice);
        return new DevicePath(nextDevice, Set.copyOf(newPath));
    }
}
