package per.blacksnow.mydefine;
/**
 * 测试wait/notify
 */
public class ThreadWaitNotifyDemo {
    public static void main( String[] args ) {
        Object obj = new Object();
        new Thread(()->{
            try {
                synchronized (obj) {
                    obj.wait();
                    System.out.println("我是thread-0,我被叫醒了，可以执行wait后的代码");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            System.out.println("我是thread-1专门用来叫醒thread-0的");
            try {
                synchronized (obj) {
                    System.out.println("4s后我来叫醒thread-0");
                    Thread.sleep(4000);
                    obj.notify();
                    System.out.println("4s到了，虽然我调用了notify方法，但我不会马上释放锁，我还跑完我自己的代码，大概要花4s左右");
                    Thread.sleep(4000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
