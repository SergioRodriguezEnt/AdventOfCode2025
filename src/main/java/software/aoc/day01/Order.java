package software.aoc.day01;

public record Order(int sign, int amount){
    public Order(String order) {
        this(signOf(order), amountOf(order));
    }

    private static int amountOf(String order) {
        return Integer.parseInt(order.substring(1));
    }

    private static int signOf(String order) {
        return order.charAt(0) == 'L' ? -1 : 1;
    }

    public int rotation() {
        return sign * amount;
    }
}