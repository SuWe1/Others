package observer;

public class ConcreteUser extends User {

	@Override
	public void update(String str) {
		System.out.println(str);
	}
}
