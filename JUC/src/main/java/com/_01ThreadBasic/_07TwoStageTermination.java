package com._01ThreadBasic;


import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TwoStageTermination
 * @Description TODO
 * @Author jing
 * @Date 2026/11/13 21:06
 */

@Slf4j(topic = "TwoStageTermination")
public class _07TwoStageTermination {
    public static void main(String[] args) throws InterruptedException {
        TwoStageTerminationDomain twoStageTerminationDomain = new TwoStageTerminationDomain();
        twoStageTerminationDomain.start();
        Thread.sleep(3500);
        twoStageTerminationDomain.stop();
    }
}

@Slf4j(topic = "TwoStageTerminationDomain")
class TwoStageTerminationDomain{
    private Thread monitor;

    public void start(){
        monitor = new Thread(()->{
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted){
                    log.info("被打断了，料理后事");
                    break;
                }
                try {
                    Thread.sleep(2000);
                    log.info("执行监控记录");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    log.info("睡眠中被打断了，设置打断标记");
                    Thread.currentThread().interrupt();
                }
            }
        },"monitor");
        monitor.start();
    }

    public void stop(){
        monitor.interrupt();
    }
}
