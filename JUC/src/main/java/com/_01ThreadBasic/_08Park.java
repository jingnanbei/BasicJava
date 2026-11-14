package com._01ThreadBasic;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName ParkTest
 * @Description LockSupport.park();
 * 该方法可以让线程暂停执行，作用与sleep()类似，但是需要执行LockSupport.unpark()方法或者执行interrupt()才能打断，然后继续执行后面代码
 * 可以先于park()之前执行unpark()
 * @Author jing
 * @Date 2026/11/14 11:28
 */

@Slf4j(topic = "ParkTest")
public class _08Park {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                log.info("线程正常执行");
                log.info("线程park");
                LockSupport.park();
                log.info("unpark");
            }
        });
        t1.start();

        t1.interrupt();
    }
}
