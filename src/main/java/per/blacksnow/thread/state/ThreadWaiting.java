package per.blacksnow.thread.state;

/**
 * 测试查看线程状态：WAITING
 */
public class ThreadWaiting {
    public static void main( String[] args ) {
        Object obj = new Object();
        new Thread(()->{
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
