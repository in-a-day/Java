package club.margay.git;

/**
 * @author margay
 */
public enum ImplInterface implements Operation{
    /**
     * 枚举可以实现接口来模拟可拓展的枚举类型
     */
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    ImplInterface(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        Operation op = ImplInterface.PLUS;
        System.out.println(op.apply(1, 2));
        System.out.println(op);
    }
}
