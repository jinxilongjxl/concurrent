package per.blacksnow.thread.interrupt;

/**
 * @author XiLongJin 演示stop（）的线程不安全性
 *
 */
public class UnsafeWithStop extends Thread {

	private int i;
	private int j;

	@Override
	public void run() {
		i++;
		// simulate very time consuming work...
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		j++;
	}

	public void printf() {
		System.out.println("变量i的值为" + i);
		System.out.println("变量j的值为" + j);
	}

	public static void main(String[] args) throws InterruptedException {
		UnsafeWithStop unsafeWithStop = new UnsafeWithStop();
		unsafeWithStop.start();
		Thread.sleep(1000);
		unsafeWithStop.stop();
		unsafeWithStop.printf();
	}
}
