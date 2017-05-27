

/**
 * 有三个线程T1，T2，T3，怎么确保它们按顺序执行？
 * 在多线程中有多种方法让线程按特定顺序执行，你可以用线程类的join()方法在一个线程中启动另一个线程，
 * 另外一个线程完成该线程继续执行。为了确保三个线程的顺序你应该先启动最后一个(T3调用T2，T2调用T1)，这样T1就会先完成而T3最后完成
 * 
 * @author 11033
 *
 */
public class SequenceExecuteThread {

	public SequenceExecuteThread() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("thread1 is completed");
			}
		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					thread1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread2 is completed");
			}
		});
		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					thread2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("thread3 is completed");
			}
		});

		thread3.start();
		thread2.start();
		thread1.start();

	}

}
