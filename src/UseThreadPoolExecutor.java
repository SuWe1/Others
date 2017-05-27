

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class UseThreadPoolExecutor {

	public UseThreadPoolExecutor() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			/*
			 * 可以使用execute提交的任务，但是execute方法没有返回值，所以无法判断任务是否被线程池执行成功 也可以使用submit
			 * 方法来提交任务，它会返回一个future,那么我们可以通过这个future来判断任务是否执行成功，
			 * 通过future的get方法来获取返回值，get方法会阻塞住直到任务完成，而使用get(long timeout,
			 * TimeUnit unit)方法则会阻塞一段时间后立即返回， 这时有可能任务没有执行完
			 */
			Future<Object> future = (Future<Object>) executor.submit(new Task(i));
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	final static class Task implements Runnable {
		private int taskId;

		public Task(int id) {
			this.taskId = id;
		}

		@Override
		public void run() {
			System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
		}

	}

}