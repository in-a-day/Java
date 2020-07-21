package cc.margay.proxy.deom1;

public class Fish implements Animal {
    private int i;

    public int getI() {
        return i;
    }

    public void setI(int v) {
        i = v;
    }

    @Override
    public void say() {
        System.out.println("fish say");
    }
}
