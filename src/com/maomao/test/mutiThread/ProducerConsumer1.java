package com.maomao.test.mutiThread;

/**
 * 生产者和消费者，wait()和notify()的实现
 * @author Administrator
 * @date 2019/5/8
 */
public class ProducerConsumer1 {
        private static Integer count = 0;
        private static final Integer FULL = 10;
        private static String LOCK = "lock";
        public static void main(String[] args) {
            ProducerConsumer1 test1 = new ProducerConsumer1();
            new Thread(test1.new Producer()).start();
            new Thread(test1.new Consumer()).start();
            new Thread(test1.new Producer()).start();
           // new Thread(test1.new Consumer()).start();

        }
        class Producer implements Runnable {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (LOCK) {
                        while (count == FULL) {
                            try {
                                LOCK.wait();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        count++;
                        System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                        LOCK.notifyAll();
                    }
                }
            }
        }
        class Consumer implements Runnable {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (LOCK) {
                        while (count == 0) {
                            try {
                                LOCK.wait();
                            } catch (Exception e) {
                            }
                        }
                        count--;
                        System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                        LOCK.notifyAll();
                    }
                }
            }
        }

}
