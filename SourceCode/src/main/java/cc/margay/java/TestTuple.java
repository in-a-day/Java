package cc.margay.java;

class ThreeTuple<A, B, C> {
    public final A a;
    public final B b;
    public final C c;

    ThreeTuple(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "(" + a + "," + b + "," + "c" + ")" ;
    }
}


public class TestTuple {
    public static void main(String[] args) {
        ThreeTuple<Integer, String , String> t = new ThreeTuple(1, "hello", "world");
        System.out.println(t);
    }
}
