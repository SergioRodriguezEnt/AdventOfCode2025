package software.aoc.day01.a;

import software.aoc.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Day01ARunner implements Runner<Integer> {
    private Stream<Order> instructions;

    @Override
    public Integer runFrom(InputStream file) {
        try (InputStreamReader isr = new InputStreamReader(file); BufferedReader br = new BufferedReader(isr)) {
            loadInstructionsFrom(br);
            return runInstructions();
        } catch (IOException e) {
            System.err.println("Error while reading instructions from file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void loadInstructionsFrom(BufferedReader br) {
        instructions = br.lines().map(Order::new);
    }

    private Integer runInstructions() {
        return instructions
                .reduce(new DialState(new Dial(), 0),
                        DialState::nextWith,
                        (_, b) -> b)
                .zeroCount;
    }

    private record DialState(Dial dial, int zeroCount) {
        DialState nextWith(Order order) {
            Dial newDial = order.apply(dial);
            return new DialState(newDial, zeroCount + (newDial.position() == 0 ? 1 : 0));
        }
    }
}
