public enum EnumDemo{
    PLUS(1, "加"){
        @Overide
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS(2, "减") {
        @Overide
        public double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES(3, "乘") {
        @Overide
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE(4, "除") {
        @Overide
        public double apply(double a, double b) {
            return a / b;
        }
    };

    String val;
    String desc;

    /**
     * 每个枚举类应当避免使用ordinal方法获取序数,
     * 取而代之使用字定义的数字
     */
    EnumDemo(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    /**
     * 每个枚举属性都需要实现抽象方法,
     * 使用抽象方法可以避免使用switch
     * effective java 中称该方法为 特定于常量的方法实现(constant-specific method implementation)
     */
    public abstract double apply(double a, double b);
}
