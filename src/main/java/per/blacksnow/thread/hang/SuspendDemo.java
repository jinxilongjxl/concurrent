package per.blacksnow.thread.hang;

/**
 * 演示Suspend挂起线程
 * 正常运行
 */
public class SuspendDemo extends Thread {

    private Object obj = new Object();

    @Override
    public void run() {
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName() + "抢到了obj对象锁，占用资源，执行suspend before...，执行了suspend不会释放锁");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main( String[] args ) throws InterruptedException {
        Thread t1 = new SuspendDemo();
        t1.start();
        Thread.sleep(3000);
        t1.resume();

        Thread t2 = new SuspendDemo();
        t2.start();
        t2.sleep(3000);
        t2.resume();
    }

}
