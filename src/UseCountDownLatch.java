

import java.util.concurrent.CountDownLatch;
/*
һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ���
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
				System.out.println("���߳�" + Thread.currentThread().getName() + "����ִ��");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("���߳�" + Thread.currentThread().getName() + "ִ�����");
				latch.countDown();// �ݼ��������ļ�����������������㣬���ͷ����еȴ����߳�
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("���߳�" + Thread.currentThread().getName() + "����ִ��");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("���߳�" + Thread.currentThread().getName() + "ִ�����");
				latch.countDown();// �ݼ��������ļ�����������������㣬���ͷ����еȴ����߳�
			}
		}).start();
		
		
		System.out.println("�ȴ�2�����߳�ִ�����...");
        try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("2�����߳��Ѿ�ִ�����");
        System.out.println("����ִ�����߳�");
	}
}
