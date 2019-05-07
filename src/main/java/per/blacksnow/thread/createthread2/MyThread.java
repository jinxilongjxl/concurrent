package per.blacksnow.thread.createthread2;
/**
 * 创建线程的方式下
 * 使用匿名内部类
 */
public class MyThread {
    public static void main( String[] args ) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running");
            }
        }, "mythread-0").start();
    }
}
