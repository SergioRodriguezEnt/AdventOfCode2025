package software.aoc.day11;

import java.util.*;
import java.util.function.Predicate;

public record PathFinder(Map<String, List<String>> devices) {
    public static PathFinder from(List<String> strs) {
        Map<String, List<String>> devices = new HashMap<>();
        strs.forEach(str -> {
            List<String> line = Arrays.asList(str.split(" "));
            devices.put(line.getFirst().substring(0, line.getFirst().length() - 1), line.subList(1, line.size()));
        });
        return new PathFinder(devices);
    }

    public int paths() {
        return findPaths("you", _ -> true);
    }

    public long serverPaths() {
        return findPaths("svr", PathFinder::currentPathPassesThroughNodes);
    }

    private static boolean currentPathPassesThroughNodes(Set<String> currentPath) {
        return currentPath.containsAll(Set.of("fft", "dac"));
    }

    private int findPaths(String initial, Predicate<Set<String>> counterFilter) {
        int count = 0;
        Stack<Set<String>> paths = new Stack<>();
        Stack<String> alive = new Stack<>();

        alive.push(initial);
        paths.push(Set.of());

        while (!alive.empty()) {
            String current = alive.pop();
            Set<String> currentPath = paths.pop();

            if (current.equals("out")) {
                if (counterFilter.test(currentPath)) {
                    count++;
                }
                continue;
            }

            for (String next : devices.get(current)) {
                if (currentPath.contains(next)) continue;
                alive.push(next);
                Set<String> newPath = new HashSet<>(currentPath);
                newPath.add(next);
                paths.push(newPath);
            }
        }

        return count;
    }
}
