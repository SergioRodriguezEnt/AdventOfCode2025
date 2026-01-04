package software.aoc.day10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public record Indicator(List<State> states, List<Integer> voltages) {
    public Indicator initialState() {
        return new Indicator(states.stream().map(_->State.OF).toList(), voltages.stream().map(_-> 0).toList());
    }

    public State switchState(int index) {
        return states.get(index) == State.ON ? State.OF : State.ON;
    }

    public Indicator reduceVoltagesWith(Indicator other) {
        return new Indicator(states, IntStream.range(0, voltages.size()).map(i->voltages.get(i)-other.voltages.get(i)).boxed().toList());
    }

    public Indicator halfVoltages() {
        return new Indicator(states, voltages.stream().map(n->n/2).toList());
    }

    public static Indicator from(String states, String requiredVoltages) {
        return new Indicator(State.from(states), voltagesFrom(requiredVoltages));
    }

    private static List<Integer> voltagesFrom(String requiredVoltages) {
        return Arrays.stream(requiredVoltages.substring(1, requiredVoltages.length() - 1).split(","))
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != Indicator.class) return false;
        return this.matchesStatesOf((Indicator) obj);
    }

    private boolean matchesStatesOf(Indicator other) {
        return states.size() == other.states.size()
                && IntStream.range(0, states.size())
                .allMatch(i -> states.get(i) == other.states.get(i));
    }

    @Override
    public int hashCode() {
        return voltages.hashCode();
    }

    public enum State {
        ON, OF;

        public static List<State> from(String states) {
            return states.substring(1, states.length() - 1).chars().mapToObj(c -> State.of((char) c)).toList();
        }

        private static State of(char c) {
            return c == '#' ? ON : OF;
        }
    }
}
