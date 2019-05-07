package per.blacksnow.thread.hang;

/**
 * 演示wait/notify，
 * 主要把SuspendDeadLock代码拷过来
 */
public class WaitNotifyDemo extends Thread {
    private static Object obj = new Object();

    @Override
    public void run() {
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName() + "抢到了obj对象锁，占用资源，执行suspend before...，执行了wait()会释放锁");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "释放资源");
    }

    public static void main( String[] args ) throws InterruptedException {
        Thread t1 = new WaitNotifyDemo();
        t1.setName("mythread-0");
        t1.start();
        Thread.sleep(3000);
        synchronized (obj) {
            obj.notify();
        }

        Thread t2 = new WaitNotifyDemo();
        t2.setName("mythread-1");
        t2.start();
        Thread.sleep(1000);
        // wait()会释放锁，所以下面这段代码能抢到锁
        synchronized (obj) {
            obj.notify();
        }
    }

}
