package per.blacksnow.thread.guard;

public class DaemonThreadDemo implements Runnable {

	private int count;

	@Override
	public void run() {
		while (true) {
			System.out.println(Thread.currentThread().getName() + " " + ++count);
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new DaemonThreadDemo());
		thread.setDaemon(true);
		thread.start();
		Thread.sleep(5000L);
	}
}