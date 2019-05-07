package per.blacksnow.thread.createthread1;

/**
 * 创建线程的方式上 实现Runnable接口1，并实现run方法
 */
public class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running.......");
	}

	public static void main(String[] args) {
		new Thread(new MyRunnable()).start();
	}
}
