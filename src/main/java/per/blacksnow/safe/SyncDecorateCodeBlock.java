package per.blacksnow.safe;

/**
 * @author XiLongJin 饰代码块：锁住传入的指定的对象
 */
public class SyncDecorateCodeBlock {

	// 互斥锁
	private Object mutexLock = new Object();

	private void out() {
		synchronized (mutexLock) {
			System.out.println(Thread.currentThread().getName());
			System.out.println(mutexLock);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		SyncDecorateCodeBlock syncDecorateCodeBlock = new SyncDecorateCodeBlock();
//		new Thread(() -> {
//			syncDecorateCodeBlock.out();
//		}).start();
//
//		new Thread(() -> {
//			syncDecorateCodeBlock.out();
//		}).start();

		SyncDecorateCodeBlock syncDecorateCodeBlock = new SyncDecorateCodeBlock();
		SyncDecorateCodeBlock syncDecorateCodeBlock2 = new SyncDecorateCodeBlock();
		new Thread(() -> {
			syncDecorateCodeBlock.out();
		}).start();

		new Thread(() -> {
			syncDecorateCodeBlock2.out();
		}).start();

	}
}
