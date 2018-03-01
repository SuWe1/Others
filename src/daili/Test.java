package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		MaoTaiJiu maoTai=new MaoTaiJiu();
		
		InvocationHandler jingxiaoa=new GuiTaiA(maoTai);
		
		SellWine dynamicProxy =(SellWine) Proxy.newProxyInstance(MaoTaiJiu.class.getClassLoader(), MaoTaiJiu.class.getInterfaces(), jingxiaoa);
		dynamicProxy.maijiu();
		
		Wuliangye wuliangye=new Wuliangye();
		
        InvocationHandler jingxiaob=new GuiTaiA(wuliangye);
		
		SellWine dynamicProxyb =(SellWine) Proxy.newProxyInstance(Wuliangye.class.getClassLoader(), Wuliangye.class.getInterfaces(), jingxiaob);
		dynamicProxyb.maijiu();
		
		
	}

}
