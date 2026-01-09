package software.aoc.day06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperationBuilder {
    private List<String> operands;
    private String operators;
    private int maxLength = 0;

    public OperationBuilder() {
        operands = new ArrayList<>();
    }

    public OperationBuilder add(String str) {
        if (str.length() > maxLength) maxLength = str.length();
        if (Operator.isOperator(str.charAt(0))) operators = str;
        else operands.add(str);
        return this;
    }

    public Stream<Operation> buildSimple() {
        return buildWith(this::simpleOperands);
    }

    public Stream<Operation> buildComplex() {
        return buildWith(this::complexOperands);
    }

    private Stream<Operation> buildWith(BiFunction<List<Integer>, Integer, List<Long>> operandParser) {
        operands = operands.stream().map(this::fill).toList();
        List<Integer> indexes = operationStartIndexes();
        return operationsFrom(operatorList(indexes), operandLists(indexes, operandParser));
    }

    private List<List<Long>> operandLists(List<Integer> indexes, BiFunction<List<Integer>, Integer, List<Long>> operandParser) {
        return IntStream.range(0, indexes.size())
                .mapToObj(i -> operandParser.apply(indexes, i))
                .toList();
    }

    private List<Long> simpleOperands(List<Integer> indexes, int i) {
        return operands.stream()
                .map(operand -> Long.parseLong(operand.substring(
                        indexes.get(i),
                        i + 1 < indexes.size() ? indexes.get(i + 1) : maxLength).strip()))
                .toList();
    }

    private List<Long> complexOperands(List<Integer> indexes, int i) {
        return IntStream.range(indexes.get(i), (i + 1 < indexes.size() ? indexes.get(i + 1) - 1 : maxLength))
                .mapToObj(this::operandAt)
                .map(Long::parseLong)
                .toList();
    }

    private String operandAt(int j) {
        return operands.stream().reduce(
                "0",
                (finalOperand, operand) -> finalOperand.concat(String.valueOf(operand.charAt(j))).strip(),
                (_, b) -> b);
    }

    private List<Operator> operatorList(List<Integer> indexes) {
        return indexes.stream()
                .mapToInt(current -> current)
                .mapToObj(current -> Operator.from(String.valueOf(operators.charAt(current))))
                .toList();
    }

    private List<Integer> operationStartIndexes() {
        return IntStream.range(0, operators.length())
                .filter(i -> Operator.isOperator(operators.charAt(i)))
                .boxed()
                .toList();
    }

    private static Stream<Operation> operationsFrom(List<Operator> operatorList, List<List<Long>> operandLists) {
        return IntStream.range(0, operatorList.size())
                .mapToObj(i -> new Operation(operandLists.get(i), operatorList.get(i)));
    }

    private String fill(String str) {
        return str.concat(" ".repeat(maxLength - str.length()));
    }
}
