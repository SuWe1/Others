package state;

public class Context {
	//维护一个State子类的实例，这个实例定义了当前的状态
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * 用户感兴趣的接口方法
     */
    public void powerOn(){
    	setState(new ConcreteStateOpen());
    	System.out.println("开启啦");
    }
    public void powerOff() {
		setState(new ConcreteStateClose());
		System.out.println("关闭啦");
	}
    public void C() {
		state.connect();
	}
    
    public void O() {
    	state.off();
	}
}
