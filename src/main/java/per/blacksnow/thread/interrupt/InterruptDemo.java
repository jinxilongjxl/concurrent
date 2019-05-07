package per.blacksnow.thread.interrupt;

/**
 * @author XiLongJin 演示interrupt（）的使用
 *
 */
public class InterruptDemo implements Runnable {

	private int counter = 0;

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName() + "====" + ++counter);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new InterruptDemo());
		thread.start();
		Thread.sleep(1000);
		thread.interrupt();
	}

}
