package com._01ThreadBasic;


/**
 * @ClassName _03Join
 * @Description Join()
 * join()：让一个线程等待另一个线程执行结束，然后再继续执行
 * A线程调用B.join()，A线程就会等待B线程执行结束
 * join()是可中断的等待，调用线程即main线程被中断了，join会抛出InterruptedException
 * 然后main线程就不会等待t1执行完后再执行，main线程直接执行剩下的代码
 *
 * join():一直等待线程执行结束
 * join(long millis):最多等待指定毫秒数
 * join(long millis,int nanos):最多等待指定毫秒和纳秒数
 *
 * @Author jing
 * @Date 2026/11/14 11:49
 */

public class _02Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("子线程执行开始");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程执行结束");
        });

        thread.start();
        //主线程等待thread线程执行结束
        thread.join();
        System.out.println("主线程执行结束");
    }
}
