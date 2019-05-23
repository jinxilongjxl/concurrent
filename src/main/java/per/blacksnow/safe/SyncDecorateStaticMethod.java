package per.blacksnow.safe;

/**
 * @author XiLongJin 修饰j静态方法：锁住整个类
 *
 */
public class SyncDecorateStaticMethod {

	private static synchronized void out() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

//		new Thread(() -> {
//			SyncDecorateStaticMethod.out();
//		}).start();
//
//		new Thread(() -> {
//			SyncDecorateStaticMethod.out();
//		}).start();

		SyncDecorateStaticMethod syncDecorateStaticMethod = new SyncDecorateStaticMethod();
		SyncDecorateStaticMethod syncDecorateStaticMethod2 = new SyncDecorateStaticMethod();

		new Thread(() -> {
			syncDecorateStaticMethod.out();
		}).start();

		new Thread(() -> {
			syncDecorateStaticMethod2.out();
		}).start();

	}
}
