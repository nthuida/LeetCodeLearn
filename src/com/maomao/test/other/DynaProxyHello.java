package com.maomao.test.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author Administrator
 * @date 2019/4/15
 */
public class DynaProxyHello  implements InvocationHandler {
    //目标对象
    private Object target;

    public DynaProxyHello( Object target) {
        this.target = target;
    }

    /**
     * 生成代理对象
     * @return
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 通过实现该接口定义横切逻辑，并通过反射机制调用目标类的代码，
     * 动态的将横切逻辑和业务逻辑编织在一起
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("start");
        //通过反射机制来运行目标对象的方法
        result = method.invoke(this.target, args);
        System.out.println("end");
        return result;
    }

    public static void main(String[] args) {
        DynaProxyHello personProxy = new DynaProxyHello(new PersonImpl());
        Person person = (Person) personProxy.getProxy();
        person.doSomething();
    }
}
