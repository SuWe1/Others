package state;

public class ConcreteStateClose implements State{
	
	@Override
	public void connect() {
		System.out.println("关闭状态下无反应哦");
	}

    @Override
    public void off() {
    	System.out.println("关闭状态下无反应哦");
    }
}
