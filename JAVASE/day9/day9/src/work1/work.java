package work1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class work1 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行");
    }

}

public class work {
    public static void main(String[] args) {
        // 初始化线程池和线程数量
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        // 提交任务
        newFixedThreadPool.submit(new work1());
        newFixedThreadPool.submit(new work1());
        newFixedThreadPool.submit(new work1());
        newFixedThreadPool.submit(new work1());
        newFixedThreadPool.submit(new work1());
    }
}
