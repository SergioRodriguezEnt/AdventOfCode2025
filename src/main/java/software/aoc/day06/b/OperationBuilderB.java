package software.aoc.day06.b;

import software.aoc.day06.Operation;
import software.aoc.day06.OperationBuilder;
import software.aoc.day06.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperationBuilderB implements OperationBuilder {
    private List<String> operands;
    private String operators;
    private int maxLength = 0;

    public OperationBuilderB() {
        operands = new ArrayList<>();
    }

    @Override
    public OperationBuilderB add(String str) {
        if (str.length() > maxLength) maxLength = str.length();
        if (Operator.isOperator(str.charAt(0))) operators = str;
        else operands.add(str);
        return this;
    }

    @Override
    public Stream<Operation> build() {
        operands = operands.stream().map(this::fill).toList();

        List<Integer> indexes = operationStartIndexes();

        return operationsFrom(operatorList(indexes), operandLists(indexes));
    }

    private List<List<Long>> operandLists(List<Integer> indexes) {
        ArrayList<List<Long>> lists = new ArrayList<>();
        for (int i = 0; i < indexes.size(); i++) {
            ArrayList<Long> list = new ArrayList<>();

            for (int j = indexes.get(i); j < (i + 1 < indexes.size() ? indexes.get(i + 1)-1 : maxLength) ; j++) {
                String number = "0";
                for (String operand : operands) {
                    number = number.concat(String.valueOf(operand.charAt(j))).strip();
                }
                list.add(Long.parseLong(number));
            }
            lists.add(list);
        }
        return lists;
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
