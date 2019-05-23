package per.blacksnow.synopsis;

import java.util.concurrent.CountDownLatch;

/**
 * 线程不安全操作代码实例
 */
public class UnSafeThread {
	private static int num = 0;

	// 为了防止上来就输出num的值
	private static CountDownLatch countDownLatch = new CountDownLatch(10);

	/**
	 * 每次调用对num进行++操作
	 */
	public static synchronized void inCreate() {
		num++;
	}

	public static void main(String[] args) {
		// 创建10个线程，每个线程循环调用100次inCreate()
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				for (int j = 0; j < 100; j++) {
					// 为了模拟出效果，进行睡眠,不然num的值肯定是1000
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					inCreate();
				}
				// 每个线程执行完后，调用countDownLatch
				countDownLatch.countDown();
			}).start();
		}
		while (true) {
			if (countDownLatch.getCount() == 0) {
				System.out.println(num);
				break;
			}
		}
	}
}
