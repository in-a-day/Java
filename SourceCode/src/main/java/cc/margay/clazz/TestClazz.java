package cc.margay.clazz;

public class TestClazz {
    public static void main(String[] args) {
        // 并不会触发类的任何初始化, 包括静态块, 变量等.
        Class p = Person.class;
        // 静态常量也不会初始化
        String hh = Person.H;
        // 只有引用static方法(构造方法隐式地是static), 或者非常量的static字段, 才会进行类初始化.
        int a = Person.a;

        Person pp = new Person();
    }
}
