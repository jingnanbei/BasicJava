package com._01ThreadBasic;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName InterruptTest2
 * @Description 打断正常的循环
 *
 * @Author jing
 * @Date 2026/11/10 20:39
 */

@Slf4j(topic = "InterruptTest2")
public class _06Interrupt2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while(true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted){
                    log.info("打断状态{}",interrupted);
                    break;
                }
            }
        });

        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
