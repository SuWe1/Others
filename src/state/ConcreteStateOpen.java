package state;

public class ConcreteStateOpen implements State{
	
	@Override
	public void connect() {
		System.out.println("���ӳɹ�");
	}
	
	@Override
	public void off() {
		System.out.println("�Ͽ��ɹ�");
	}
}
