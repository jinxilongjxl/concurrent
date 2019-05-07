package per.blacksnow.thread.state;
/**
 * 测试查看线程状态：TIMED_WAITING
 */
public class ThreadTimeWaitingDemo {
    public static void main( String[] args ) {
        new Thread(()->{
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
