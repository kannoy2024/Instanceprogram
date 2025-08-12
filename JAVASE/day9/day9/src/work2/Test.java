package work2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        //使用callable创建线程
    Callable<Integer> task = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <1000; i++) {
                sum+=i;
            }
            return sum;
        }

    };
    Future<Integer> submit = newFixedThreadPool.submit(task);;
    System.out.println("结果是：" + submit.get());
    }
}
