package software.aoc.day11;

import java.util.*;

public record PathFinder(Map<String, List<String>> devices) {
    public static PathFinder from(List<String> data) {
        Map<String, List<String>> devices = new HashMap<>();
        data.forEach(str -> {
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

    //Iterative DFS
    private long findPaths(String initial, String target) {
        Map<String, Long> cache = new HashMap<>();
        Stack<DevicePath> alive = new Stack<>();
        Stack<Boolean> expanded = new Stack<>();

        alive.push(new DevicePath(initial, Set.of()));
        expanded.push(false);

        while (!alive.empty()) {
            exploreFirstPathRemaining(target, alive, expanded, cache);
        }

        return cache.getOrDefault(initial, 0L);
    }

    private void exploreFirstPathRemaining(String target, Stack<DevicePath> alive, Stack<Boolean> expanded, Map<String, Long> cache) {
        DevicePath current = alive.pop();
        boolean isExpanded = expanded.pop();

        if (cache.containsKey(current.device())) return;

        if (current.device().equals(target)) {
            cache.put(current.device(), 1L);
            return;
        }

        if (!isExpanded) {
            alive.push(current);
            expanded.push(true);
            if (devices.get(current.device()) == null) return;
            addPossiblePathsFrom(current, alive, expanded);
            return;
        }

        cache.put(current.device(), accumulateResultsObtainedAfter(current.device(), cache));
    }

    private void addPossiblePathsFrom(DevicePath current, Stack<DevicePath> alive, Stack<Boolean> expanded) {
        devices.get(current.device())
                .stream()
                .filter(next->!current.path().contains(next))
                .forEach(next-> {
                    alive.push(current.continueWith(next));
                    expanded.push(false);
                });
    }

    private long accumulateResultsObtainedAfter(String current, Map<String, Long> cache) {
        return devices.getOrDefault(current, List.of())
                .stream()
                .mapToLong(next -> cache.getOrDefault(next, 0L))
                .sum();
    }
}
