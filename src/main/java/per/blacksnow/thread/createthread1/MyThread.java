package per.blacksnow.thread.createthread1;

/**
 * 创建线程的方式上 继承Thread类，并重写父类的run方法 test1
 */
public class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}

	public static void main(String[] args) {
		new MyThread().start();
	}
}
