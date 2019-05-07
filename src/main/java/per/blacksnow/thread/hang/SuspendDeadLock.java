package per.blacksnow.thread.hang;

/**
 * 演示suspend运行时发生死锁
 */
public class SuspendDeadLock extends Thread {
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
        Thread t1 = new SuspendDeadLock();
        t1.setName("mythread-0");
        t1.start();
        Thread.sleep(3000);
        t1.resume();

        Thread t2 = new SuspendDeadLock();
        t2.setName("mythread-1");
        t2.start();
        t2.resume();
    }
}
