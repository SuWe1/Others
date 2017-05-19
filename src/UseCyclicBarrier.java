import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class UseCyclicBarrier {

	/**
	 * ÿ��д���߳�ִ����д���ݲ���֮�󣬾��ڵȴ������߳�д�������ϡ�
�����������߳��߳�д��������֮�������߳̾ͼ������к����Ĳ�����
	 */
	public static void Common() {
		int N=4;
//		CyclicBarrier cyclicBarrier=new CyclicBarrier(N);
		
		
		//���ĸ��̶߳�����barrier״̬�󣬻���ĸ��߳���ѡ��һ���߳�ȥִ��Runnable��
		CyclicBarrier cyclicBarrier=new CyclicBarrier(N,new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("��ǰ�߳�"+Thread.currentThread().getName());
			}
		});
		for (int i = 0; i < N; i++) {
			new Write(cyclicBarrier).start();
		}
		
		
		try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        System.out.println("CyclicBarrier����");
         
        //CyclicBarrier����
        for(int i=0;i<N;i++) {
            new Write(cyclicBarrier).start();
        }
	}

	static class Write extends Thread{
		private CyclicBarrier cyclicBarrier;
		public Write(CyclicBarrier cyclicBarrier) {
			super();
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.out.println("�߳�"+Thread.currentThread().getName()+"����д������...");
            try {
                Thread.sleep(5000);      //��˯����ģ��д�����ݲ���
                System.out.println("�߳�"+Thread.currentThread().getName()+"д��������ϣ��ȴ������߳�д�����");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("�����߳�д����ϣ�����������������...");
		}
	}
	
	public static void main(String[] args) {
		Common();
	}
}
