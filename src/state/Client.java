package state;

public class Client {

	public static void main(String[] args) {
		/* //����״̬
		State state=new ConcreteStateOpen();
		//��������
		Context context=new Context();
		//��״̬���õ�������
		context.setState(state);
		//��������
		context.powerOn();
		context.powerOff();*/
		
		
		Context context=new Context();
		//���ÿ���״̬
		context.powerOn();
		//����
		context.C();
		//�ر�
		context.O();
		//���ùر�״̬
		context.powerOff();
		context.C();
	}
}
