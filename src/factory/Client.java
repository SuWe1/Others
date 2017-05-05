package factory;

public class Client {
	public static void main(String[] args) {
		Factory factoryA=new ConcreteFactoryA();
		Product productA=factoryA.createProduct();
		productA.method();
		
		Factory factoryB=new ConcreteFactoryB();
		Product productB=factoryB.createProduct();
		productB.method();
	}
}
