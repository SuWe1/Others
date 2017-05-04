

/*public class Singleton {
	private Singleton() {}
	
	public static final Singleton getInstance(){
		return MyInstance.INSTANCE;
	}
	
	private static class MyInstance{
		private static final Singleton INSTANCE=new Singleton();
	}
}*/
public class Singleton{
	private Singleton() {}
	private static final Singleton INSTANCE=new Singleton();
	
	public static final Singleton getInstance(){
		return INSTANCE;
	}
}
