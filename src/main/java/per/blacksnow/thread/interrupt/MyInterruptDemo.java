package per.blacksnow.thread.interrupt;

/**
 * @author XiLongJin 演示用设置FLAG来中断线程
 *
 */
public class MyInterruptDemo implements Runnable {

	private static volatile boolean FLAG = true;
	private int counter = 0;

	@Override
	public void run() {
		while (FLAG) {
			System.out.println(Thread.currentThread().getName() + "===" + ++counter);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new MyInterruptDemo());
		thread.start();
		Thread.sleep(1000);
		FLAG = false;
	}

}
