

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
			 * ����ʹ��execute�ύ�����񣬵���execute����û�з���ֵ�������޷��ж������Ƿ��̳߳�ִ�гɹ� Ҳ����ʹ��submit
			 * �������ύ�������᷵��һ��future,��ô���ǿ���ͨ�����future���ж������Ƿ�ִ�гɹ���
			 * ͨ��future��get��������ȡ����ֵ��get����������סֱ��������ɣ���ʹ��get(long timeout,
			 * TimeUnit unit)�����������һ��ʱ����������أ� ��ʱ�п�������û��ִ����
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