

/**
 * �������߳�T1��T2��T3����ôȷ�����ǰ�˳��ִ�У�
 * �ڶ��߳����ж��ַ������̰߳��ض�˳��ִ�У���������߳����join()������һ���߳���������һ���̣߳�
 * ����һ���߳���ɸ��̼߳���ִ�С�Ϊ��ȷ�������̵߳�˳����Ӧ�����������һ��(T3����T2��T2����T1)������T1�ͻ�����ɶ�T3������
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
