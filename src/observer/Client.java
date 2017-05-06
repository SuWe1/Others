package observer;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//创建被观察者
		ConcreteBlog blog=new ConcreteBlog();
		//创建观察者
		ConcreteUser user1=new ConcreteUser();
		ConcreteUser user2=new ConcreteUser();
		ConcreteUser user3=new ConcreteUser();
		//将观察者注册到可观察对象的观察者列表中
		blog.addUser(user1);
		blog.addUser(user2);
		blog.addUser(user3);
		
		blog.notifyChanged("发布博客了,快来看啊！");
	}

}
