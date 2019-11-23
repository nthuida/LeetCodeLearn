package com.maomao.test.mutiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author huida.mao
 * @Date 2019/10/31
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(new readNum(i,countDownLatch)).start();
        }
        System.out.println("主线程运行");
        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class readNum  implements Runnable{
        private int id;
        private CountDownLatch latch;
        public readNum(int id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }
        @Override
        public void run() {
                System.out.println("id:"+id);
                latch.countDown();
                //继续执行
                System.out.println("线程组任务"+id+"结束，其他任务继续");
        }
    }
}
