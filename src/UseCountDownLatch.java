

import java.util.concurrent.CountDownLatch;
/*
一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
**/
public class UseCountDownLatch {

	public UseCountDownLatch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
				latch.countDown();// 递减锁存器的计数，如果计数到达零，则释放所有等待的线程
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
				latch.countDown();// 递减锁存器的计数，如果计数到达零，则释放所有等待的线程
			}
		}).start();
		
		
		System.out.println("等待2个子线程执行完毕...");
        try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("2个子线程已经执行完毕");
        System.out.println("继续执行主线程");
	}
}
