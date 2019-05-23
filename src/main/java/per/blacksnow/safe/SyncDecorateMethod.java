package per.blacksnow.safe;

/**
 * @author XiLongJin 修饰普通方法：锁住对象的实例
 */
public class SyncDecorateMethod {

	private synchronized void out() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		SyncDecorateMethod syncDecorateMethod = new SyncDecorateMethod();
//
//		new Thread(() -> {
//			syncDecorateMethod.out();
//		}).start();
//
//		new Thread(() -> {
//			syncDecorateMethod.out();
//		}).start();

		SyncDecorateMethod syncDecorateMethod = new SyncDecorateMethod();
		SyncDecorateMethod syncDecorateMethod2 = new SyncDecorateMethod();

		new Thread(() -> {
			syncDecorateMethod.out();
		}).start();

		new Thread(() -> {
			syncDecorateMethod2.out();
		}).start();

	}

}
