package cc.margay.proxy.deom1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalHandler implements InvocationHandler {
    private Animal animal;

    public AnimalHandler(Animal animal) {
        this.animal = animal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method: " + method.getName());
        System.out.println("args: ");
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
        return method.invoke(animal, args);
    }
}
