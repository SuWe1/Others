package state;

public class Client {

	public static void main(String[] args) {
		/* //创建状态
		State state=new ConcreteStateOpen();
		//创建环境
		Context context=new Context();
		//将状态设置到环境中
		context.setState(state);
		//具体请求
		context.powerOn();
		context.powerOff();*/
		
		
		Context context=new Context();
		//设置开启状态
		context.powerOn();
		//开启
		context.C();
		//关闭
		context.O();
		//设置关闭状态
		context.powerOff();
		context.C();
	}
}
