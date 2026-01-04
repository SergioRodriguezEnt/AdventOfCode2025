package software.aoc.day10;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public record Button(Set<Integer> states) {
    public static Button from(String button) {
        return new Button(Arrays.stream(button.substring(1, button.length() - 1).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet()));
    }
}
