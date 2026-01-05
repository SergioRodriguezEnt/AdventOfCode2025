package software.aoc.day11;

import java.util.*;

public record PathFinder(Map<String, List<String>> devices) {
    public static PathFinder from(List<String> strs) {
        Map<String, List<String>> devices = new HashMap<>();
        strs.forEach(str -> {
            List<String> line = Arrays.asList(str.split(" "));
            devices.put(line.getFirst().substring(0, line.getFirst().length() - 1), line.subList(1, line.size()));
        });
        return new PathFinder(devices);
    }

    public long paths() {
        return findPaths("you", "out");
    }

    public long serverPaths() {
        return fftFirstPaths()+dacFirstPaths();
    }

    private long dacFirstPaths() {
        long sdPaths = findPaths("svr", "dac");
        System.out.println("sdPaths = " + sdPaths);
        if (sdPaths == 0) return 0;
        long dfPaths = findPaths("dac", "fft");
        System.out.println("dfPaths = " + dfPaths);
        if (dfPaths == 0) return 0;
        long foPaths = findPaths("fft", "out");
        System.out.println("foPaths = " + foPaths);
        if (foPaths == 0) return 0;
        return sdPaths * dfPaths * foPaths;
    }

    private long fftFirstPaths() {
        long sfPaths = findPaths("svr", "fft");
        System.out.println("sfPaths = " + sfPaths);
        if (sfPaths == 0) return 0;
        long fdPaths = findPaths("fft", "dac");
        System.out.println("fdPaths = " + fdPaths);
        if (fdPaths == 0) return 0;
        long doPaths = findPaths("dac", "out");
        System.out.println("doPaths = " + doPaths);
        if (doPaths == 0) return 0;
        return sfPaths * fdPaths * doPaths;
    }

    private long findPaths(String initial, String target) {
        Map<String, Long> cache = new HashMap<>();
        Stack<Set<String>> paths = new Stack<>();
        Stack<String> alive = new Stack<>();
        Stack<Boolean> expanded = new Stack<>();

        alive.push(initial);
        paths.push(Set.of());
        expanded.push(false);

        while (!alive.empty()) {
            String current = alive.pop();
            Set<String> currentPath = paths.pop();
            boolean isExpanded = expanded.pop();

            if (cache.containsKey(current)) continue;

            if (current.equals(target)) {
                cache.put(current, 1L);
                continue;
            }

            if (!isExpanded) {
                alive.push(current);
                paths.push(currentPath);
                expanded.push(true);
                if (devices.get(current) == null) continue;
                for (String next : devices.get(current)) {
                    if (currentPath.contains(next)) continue;
                    alive.push(next);
                    Set<String> newPath = new HashSet<>(currentPath);
                    newPath.add(next);
                    paths.push(newPath);
                    expanded.push(false);
                }
                continue;
            }

            long internalCount = 0;
            if (devices.get(current) != null) {
                for (String next : devices.get(current)) {
                    internalCount += cache.getOrDefault(next, 0L);
                }
            }
            cache.put(current, internalCount);
        }

        return cache.getOrDefault(initial, 0L);
    }
}
