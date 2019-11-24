package com.maomao.test.mutiThread;

import java.util.concurrent.atomic.AtomicReference;


public class Singleton {
    /** 利用AtomicReference */
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();

    /**
     * 私有化
     */
    private Singleton(){
    }

    /**
     * 用CAS确保线程安全
     * CAS的自旋循环如果长时间不成功，则会给CPU带来非常大的执行开销。
     * 另外一点就是如果N个线程同时执行到singleton=new Singleton()的时候，则会同时创建大量的实例，很有可能发生OOM。
     * @return
     */
    public static final Singleton getInstance(){
        for (;;) {
            Singleton current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new Singleton();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }


    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        for (int i=0; i<10;i++) {
            new Thread(() ->System.out.println(Singleton.getInstance())
            ).start();
        }
    }

}
