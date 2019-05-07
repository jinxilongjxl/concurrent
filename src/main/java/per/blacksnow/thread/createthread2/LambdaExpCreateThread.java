package per.blacksnow.thread.createthread2;

/**
 * 创建线程的方式下
 * 使用Labmda表达式
 */
public class LambdaExpCreateThread {
    public static void main( String[] args ) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is running");
        }, "mythread-0").start();
    }
}
