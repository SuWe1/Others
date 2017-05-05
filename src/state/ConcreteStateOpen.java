package state;

public class ConcreteStateOpen implements State{
	
	@Override
	public void connect() {
		System.out.println("连接成功");
	}
	
	@Override
	public void off() {
		System.out.println("断开成功");
	}
}
