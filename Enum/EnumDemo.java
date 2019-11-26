package club.margay.git;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EnumDemo{
    PLUS(1, "加"){
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },
    MINUS(2, "减") {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    },
    TIMES(3, "乘") {
        @Override
        public double apply(double a, double b) {
            return a * b;
        }
    },
    DIVIDE(4, "除") {
        @Override
        public double apply(double a, double b) {
            return a / b;
        }
    };

    int val;
    String desc;

    /**
     * 每个枚举类应当避免使用ordinal方法获取序数,
     * 取而代之使用字定义的数字
     * 枚举中无法在构造器中调用另一个构造器
     */
    EnumDemo(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    /**
     * 每个枚举属性都需要实现抽象方法,
     * 使用抽象方法可以避免使用switch
     * effective java 中称该方法为 特定于常量的方法实现(constant-specific method implementation)
     */
    public abstract double apply(double a, double b);

    /**
     * Enum中的values()方法遍历enum中的所有值
     * valueOf()方法将给定的常量名称转为对应的常量
     * 枚举的静态域在构造器后初始化
     */
    public static final Map<Integer, EnumDemo> intToEnum = 
        Stream.of(values()).collect(Collectors.toMap(EnumDemo::getVal, Function.identity()));

    public static Optional<EnumDemo> fromInt(int val) {
        return Optional.ofNullable(intToEnum.get(val));
    }

    /**
     * 通用, 添加属性误需修改代码, 可以使用这种方式
     * 否则可以使用constant-specific method implementation
     * 或者使用策略枚举(strategy-enum)
     */
    public int getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 重写toString改变Enum的默认输出
     */
    @Override
    public String toString() {
        return desc;
    }

    public static void main(String[] args) {
        EnumDemo[] values = EnumDemo.values();
        for (EnumDemo value : values) {
            System.out.println(value);
        }

        System.out.format("%n PLUS.val:%n\t%d", EnumDemo.PLUS.getVal());
        System.out.format("%n PLUS.toString:%n\t%s", EnumDemo.PLUS);
        System.out.format("%n 1 + 1 = %f", EnumDemo.PLUS.apply(1, 1));

        EnumDemo divide = EnumDemo.valueOf("DIVIDE");
        System.out.format("%n DIVIDE.val:%n\t%d", divide.getVal());
        System.out.format("%n DIVIDE.toString:%n\t%s", divide);
        System.out.format("%n 10 / 2 = %f", divide.apply(10 , 2));

        EnumDemo minus = EnumDemo.fromInt(2).get();
        System.out.format("%n minus.val:%n\t%d", minus.getVal());
        System.out.format("%n minus.toString:%n\t%s", minus);
        System.out.format("%n 5 - 2 = %f", minus.apply(5, 2));
    }
}
