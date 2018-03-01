package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 柜台A
 * @author Swy
 *
 */
public class GuiTaiA implements InvocationHandler{
	private Object pingpai;//酒的品种

	public GuiTaiA(Object pingpai) {
		// TODO Auto-generated constructor stub
		this.pingpai=pingpai;
	}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("销售开始，柜台是"+	this.getClass().getSimpleName());
		arg1.invoke(pingpai, arg2);
        System.out.println("销售结束");
		return null;
	}

}
