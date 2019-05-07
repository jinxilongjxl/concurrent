package per.blacksnow.thread.interrupt;

/**
 * @author XiLongJin 演示废弃方法stop的使用
 */
public class ThreadStopDemo implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new ThreadStopDemo());
		thread.start();
		Thread.sleep(5 * 1000);
		thread.stop();
		System.out.println("finish");
	}
}
