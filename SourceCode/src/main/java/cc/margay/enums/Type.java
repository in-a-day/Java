package cc.margay.enums;

import java.util.EnumMap;
import java.util.EnumSet;

public enum Type {
    /**
     *
     */
    A("a"),
    B("b"), C;

    private final String alias;

    Type() {
        this.alias = "";
    }

    Type(String alias) {
        this.alias = alias;
    }

    @Override
    public String toString() {
        return this.alias;
    }

    public static void main(String[] args) {
        EnumSet<Type> t = EnumSet.noneOf(Type.class);
        System.out.println(t);
        t.add(Type.A);
        t.add(Type.B);
        System.out.println(t);
        EnumMap<Type, Integer> m = new EnumMap(Type.class);
        System.out.println(m);
        m.put(Type.A, Type.A.ordinal());
        m.put(Type.C, Type.C.ordinal());
        System.out.println(m);
    }
}
