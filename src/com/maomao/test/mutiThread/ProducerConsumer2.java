package com.maomao.test.mutiThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *  BlockingQueue阻塞队列方法
 * @author Administrator
 * @date 2019/5/8
 */
public class ProducerConsumer2 {
        private static Integer count = 0;
        final BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
        class Producer implements Runnable {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        bq.put(1);
                        System.out.println(Thread.currentThread().getName()
                                + "生产者生产，目前总共有" + bq.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        class Consumer implements Runnable {

            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        bq.take();
                        System.out.println(Thread.currentThread().getName()
                                + "消费者消费，目前总共有" + bq.size());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        public static void main(String[] args) throws Exception {
            ProducerConsumer2 test = new ProducerConsumer2();
            new Thread(test.new Producer()).start();
            new Thread(test.new Consumer()).start();
            new Thread(test.new Producer()).start();
            //new Thread(test.new Consumer()).start();
        }


}
