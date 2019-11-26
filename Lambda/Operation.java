package club.margay.lambda;

import java.util.function.DoubleBinaryOperator;

/**
 * @author margay
 * 使用lambda实现enum操作
 */
public enum Operation {
    /**
     * 方法引用简洁时, 使用方法引用
     */
    PLUS("+", Double::sum),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        Operation op = Operation.PLUS;
        System.out.println(op.apply(1, 2));
        System.out.println(op);
    }

}
