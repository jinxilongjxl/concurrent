package per.blacksnow.thread.state;

/**
 * 测试查看线程状态：BLOCKED
 */
public class ThreadBlockedDemo {
    public static void main( String[] args ) throws InterruptedException {
        // create a lock resource objLock
        Object objLock = new Object();
        // thread-0 will be timewaiting
        new Thread(()->{
            synchronized (objLock) {
                try {
                    // thread-0 hold the objLock for 100000s
                    // which leads to other thread that want this objLock into BLOCKED state
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // thread-1 will be blocked
        new Thread(()->{
            synchronized (objLock) {
                System.out.println("我终于拿到锁可以执行代码了...");
            }
        }).start();
    }
}
