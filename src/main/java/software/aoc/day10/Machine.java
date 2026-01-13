package software.aoc.day10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Machine(Indicator desired, List<Button> buttons) {
    public static Machine from(String str) {
        List<String> data = List.of(str.split(" "));
        return new Machine(Indicator.from(data.getFirst(), data.getLast()),
                data.subList(1, data.size()-1).stream().map(Button::from).toList());
    }

    public int solveDesiredState() {
        return buttonsThatSolveDesiredState().getFirst().size();
    }

    // Iterative DFS
    public int solveVoltageRequirements() {
        Map<Indicator, Integer> cache = new HashMap<>();
        Deque<Indicator> alive = new ArrayDeque<>();
        Deque<Boolean> expanded = new ArrayDeque<>();

        alive.push(desired);
        expanded.push(false);

        while(!alive.isEmpty()) {
            exploreNextIndicatorRemaining(alive, expanded, cache);
        }

        return cache.getOrDefault(desired, 9999);
    }

    private void exploreNextIndicatorRemaining(Deque<Indicator> alive, Deque<Boolean> expanded, Map<Indicator, Integer> cache) {
        Indicator currentDesired = alive.pop();
        boolean isExpanded = expanded.pop();

        if (cache.containsKey(currentDesired)) return;

        if (currentDesired.voltages().stream().allMatch(x -> x == 0)) {
            cache.put(currentDesired, 0);
            return;
        }

        Indicator voltageIndicator = voltageIndicatorFrom(currentDesired);
        Machine voltageMachine = new Machine(voltageIndicator, buttons);
        List<Set<Button>> machineSolutions = voltageMachine.buttonsThatSolveDesiredState();

        if (!isExpanded) {
            alive.push(currentDesired);
            expanded.push(true);
            expandPossibleIndicatorStates(alive, expanded, machineSolutions, currentDesired, voltageIndicator);
            return;
        }

        cache.put(currentDesired, getBestResultAndAccumulate(cache, machineSolutions, currentDesired, voltageIndicator));
    }

    private int getBestResultAndAccumulate(Map<Indicator, Integer> cache, List<Set<Button>> machineSolutions, Indicator currentDesired, Indicator voltageIndicator) {
        return machineSolutions.stream()
                .filter(machineSolution -> willRemainPositive(currentDesired, voltageIndicator, machineSolution))
                .map(machineSolution -> {
                    Indicator middle = currentDesired.reduceVoltagesWith(applyButtonsTo(voltageIndicator, machineSolution));
                    Indicator newDesired = middle.halfVoltages();
                    return 2 * cache.get(newDesired) + machineSolution.size();
                })
                .min(Comparator.naturalOrder()).orElse(9999);
    }

    private boolean willRemainPositive(Indicator currentDesired, Indicator voltageIndicator, Set<Button> machineSolution) {
        Indicator middle = currentDesired.reduceVoltagesWith(applyButtonsTo(voltageIndicator, machineSolution));
        return middle.voltages().stream().noneMatch(x -> x < 0);
    }

    private void expandPossibleIndicatorStates(Deque<Indicator> alive, Deque<Boolean> expanded, List<Set<Button>> machineSolutions, Indicator currentDesired, Indicator voltageIndicator) {
        machineSolutions.stream()
                .filter(machineSolution -> willRemainPositive(currentDesired, voltageIndicator, machineSolution))
                .forEach(machineSolution -> {
                    Indicator middle = currentDesired.reduceVoltagesWith(applyButtonsTo(voltageIndicator, machineSolution));
                    Indicator newDesired = middle.halfVoltages();
                    alive.push(newDesired);
                    expanded.push(false);
                });
    }

    //Iterative BFS
    private List<Set<Button>> buttonsThatSolveDesiredState() {
        List<Set<Button>> solutions = new ArrayList<>();
        Set<Set<Button>> visitedCombinations = new HashSet<>();
        Queue<Set<Button>> buttonsApplied = new ArrayDeque<>();

        buttonsApplied.add(Set.of());

        while (!buttonsApplied.isEmpty()) {
            exploreNextRemainingButtonSet(buttonsApplied, visitedCombinations, solutions);
        }

        return solutions;
    }

    private void exploreNextRemainingButtonSet(Queue<Set<Button>> buttonsApplied, Set<Set<Button>> visitedCombinations, List<Set<Button>> solutions) {
        Set<Button> currentButtons = buttonsApplied.poll();

        if (visitedCombinations.contains(currentButtons)) return;
        visitedCombinations.add(currentButtons);

        assert currentButtons != null;
        if (applyButtonsTo(desired.initialState(), currentButtons).equals(desired)) {
            solutions.add(currentButtons);
        }

        expandPossibleButtonSets(buttonsApplied, currentButtons);
    }

    private void expandPossibleButtonSets(Queue<Set<Button>> buttonsApplied, Set<Button> currentButtons) {
        buttons.stream()
                .filter(button -> !currentButtons.contains(button))
                .forEach(button ->
                        buttonsApplied.add(Stream.concat(currentButtons.stream(), Stream.of(button)).collect(Collectors.toSet()))
                );
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

    private Indicator voltageIndicatorFrom(Indicator indicator) {
        return new Indicator(IntStream.range(0, indicator.states().size())
                    .mapToObj(i -> indicator.voltages().get(i)%2 == 1 ? Indicator.State.ON : Indicator.State.OF).toList(),
                indicator.initialState().voltages());
    }
}
