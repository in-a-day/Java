package cc.margay.proxy.deom1;

import java.lang.reflect.Proxy;

public class TestHandler {
    public static void main(String[] args) {
        Animal fish = new Fish();
        AnimalHandler h = new AnimalHandler(fish);
        Animal proxy = (Animal) Proxy.newProxyInstance(
                Animal.class.getClassLoader(),
                new Class[]{Animal.class},
                h
                );
        proxy.say();
    }
}
