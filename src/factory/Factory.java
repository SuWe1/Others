package factory;

public abstract class Factory {
	/**
	 * 抽象工厂方法 
	 * 具体实现由子类实现 
	 * @return 具体的产品对象
	 */
	public abstract Product createProduct();
}
