package com._01ThreadBasic;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName InterruptTest
 * @Description
 * 打断睡眠中的循环
 *
 * interrupt()不是强制停止线程，而是向线程发送一个“中断请求”，线程收到这个请求后，是否停止，如何停止由线程自身代码决定
 * interrupt()方法不会直接杀死线程，而是将线程的中断标记设置为true
 * isInterrupted()检查终端标记，返回true或者false
 *
 * **重点**
 * 当线程处于sleep(),wait()，join()等可以被中断阻塞状态的时候
 * 调用interrupt()同城会使其抛出InterruptedException
 * 并且这种异常发生的时候，线程的中断标记会被清除，从true变为false
 *
 * @Author jing
 * @Date 2026/11/3 21:30
 */

@Slf4j(topic = "c.InterruptTest")
public class _05Interrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            log.info("hello");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                log.info("检查线程是否被中断{}",Thread.currentThread().isInterrupted());
                throw new RuntimeException(e);
            }
        },"t1");

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        log.info("打断标记{}",t1.isInterrupted());

    }
}
