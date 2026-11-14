package com._01ThreadBasic;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName _08Exercise
 * @Description 第一章习题-烧水泡茶
 * 洗水壶：1second
 * 烧水：10seconds
 * 洗茶壶，拿茶叶等琐事：4seconds
 * 怎么做效率最高
 * @Author jing
 * @Date 2026/11/14 11:44
 */

@Slf4j(topic = "Exercise")
public class _09Exercise {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.info("老王洗水壶1s");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("老王烧水5s");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            log.info("小王拿茶叶1s");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("小王洗茶壶1s");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("小王戏茶叶1s");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t2.start();
        t1.start();

    }
}
