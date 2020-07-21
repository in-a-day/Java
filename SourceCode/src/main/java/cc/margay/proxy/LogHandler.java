package cc.margay.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    private Object target;

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        System.out.println("****proxy: " +  proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg);
            }
        }
        Object res = method.invoke(target, args);
        end();
        return res;
    }

    public void before() {
        System.out.println("===log begin===");
    }

    public void end() {
        System.out.println("===log end===");
    }
}
