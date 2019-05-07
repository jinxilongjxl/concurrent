package per.blacksnow.thread.createthread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式下
 * 使用线程池
 */
public class ThreadPoolCreateThread {
    public static void main( String[] args ) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName() + " is running");
        });
    }
}
