package per.blacksnow.thread.state;

import java.io.IOException;

/**
 * 测试查看线程状态：RUNNABLE
 */
public class ThreadRunnableDemo {
    public static void main( String[] args ) {
        new Thread(()->{
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
