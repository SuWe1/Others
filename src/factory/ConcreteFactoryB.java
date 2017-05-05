package factory;

public class ConcreteFactoryB extends Factory {
	@Override
	public Product createProduct() {
		return new ConcreteProductB();
	}
}
