package observer;

public class ConcreteBlog extends Blog{

	public ConcreteBlog() {
		// TODO Auto-generated constructor stub
	}
	
	public void notifyChanged(String str){
		for(int i=mObservers.size()-1;i>=0;i--){
			mObservers.get(i).update(str);
		}
	}

}
