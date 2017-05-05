package state;

public class Context {
	//ά��һ��State�����ʵ�������ʵ�������˵�ǰ��״̬
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * �û�����Ȥ�Ľӿڷ���
     */
    public void powerOn(){
    	setState(new ConcreteStateOpen());
    	System.out.println("������");
    }
    public void powerOff() {
		setState(new ConcreteStateClose());
		System.out.println("�ر���");
	}
    public void C() {
		state.connect();
	}
    
    public void O() {
    	state.off();
	}
}
