package observer;

import java.util.ArrayList;

public abstract class Blog {
	protected final ArrayList<User> mObservers = new ArrayList();
	
	public void addUser(User user){
		mObservers.add(user);
	}
	
	public void removeUser(User user){
		mObservers.remove(user);
	}
	
	public void removeAll(){
		mObservers.clear();
	}
}

