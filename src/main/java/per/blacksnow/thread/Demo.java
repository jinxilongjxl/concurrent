package per.blacksnow.thread;

import java.io.IOException;

/**
 * 测试一个程序至少有一个进程，一个进程至少有一个线程
 * 这里只有一个主线程main
 */
public class Demo {

    public static void main( String[] args ) {
        System.out.println("hello");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
