package software.aoc.day10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Machine(Indicator desired, List<Button> buttons) {
    private List<Set<Button>> buttonsThatSolveDesiredState() {
        List<Set<Button>> solutions = new ArrayList<>();
        Set<Set<Button>> visitedCombinations = new HashSet<>();
        Queue<Set<Button>> buttonsApplied = new ArrayDeque<>();

        buttonsApplied.add(Set.of());

        while (!buttonsApplied.isEmpty()) {
            Set<Button> currentButtons = buttonsApplied.poll();

            if (visitedCombinations.contains(currentButtons)) continue;
            visitedCombinations.add(currentButtons);

            if (applyButtonsTo(desired.initialState(), currentButtons).equals(desired)) solutions.add(currentButtons);

            for (Button button : buttons) {
                if (currentButtons.contains(button)) continue;
                buttonsApplied.add(Stream.concat(currentButtons.stream(), Stream.of(button)).collect(Collectors.toSet()));
            }
        }

        return solutions;
    }

    public int solveDesiredState() {
        return buttonsThatSolveDesiredState().getFirst().size();
    }

    private Indicator applyButtonsTo(Indicator currentState, Set<Button> buttons) {
        return buttons.stream().reduce(currentState, this::applyButtonTo, (_, b) -> b);
    }

    private Indicator applyButtonTo(Indicator currentState, Button button) {
        List<Indicator.State> newStates = IntStream.range(0, currentState.states().size())
                .mapToObj(i -> button.states().contains(i) ? currentState.switchState(i) : currentState.states().get(i))
                .toList();
        List<Integer> newVoltages = IntStream.range(0, currentState.voltages().size())
                .mapToObj(i -> currentState.voltages().get(i) + (button.states().contains(i) ? 1 : 0))
                .toList();
        return new Indicator(newStates, newVoltages);
    }

    public int solveVoltageRequirements(Map<Indicator, Integer> cache) {
        if (cache.containsKey(desired)) return cache.get(desired);

        if (desired.voltages().stream().allMatch(x->x==0)) {
            return 0;
        }

        Indicator initialIndicator = voltageIndicator(desired);
        Machine initialMachine = new Machine(initialIndicator, buttons);
        List<Set<Button>> machineSolutions = initialMachine.buttonsThatSolveDesiredState();

        List<Integer> solutions = new ArrayList<>();

        for (Set<Button> machineSolution : machineSolutions) {
            Indicator middle = desired.reduceVoltagesWith(applyButtonsTo(initialIndicator, machineSolution));
            if (middle.voltages().stream().anyMatch(x->x<0)) continue;
            Indicator newDesired = middle.halfVoltages();
            Machine newMachine = new Machine(newDesired, buttons);
            solutions.add(2*newMachine.solveVoltageRequirements(cache) + machineSolution.size());
        }

        return solutions.stream().min(Integer::compareTo).orElse(99999);
    }

    private Indicator voltageIndicator(Indicator indicator) {
        return new Indicator(IntStream.range(0, indicator.states().size()).mapToObj(i -> indicator.voltages().get(i)%2 == 1 ? Indicator.State.ON : Indicator.State.OF).toList(),
                indicator.initialState().voltages());
    }

    public static Machine from(String str) {
        List<String> data = List.of(str.split(" "));
        return new Machine(Indicator.from(data.getFirst(), data.getLast()),
                data.subList(1, data.size()-1).stream().map(Button::from).toList());
    }
}
