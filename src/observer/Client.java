package observer;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//�������۲���
		ConcreteBlog blog=new ConcreteBlog();
		//�����۲���
		ConcreteUser user1=new ConcreteUser();
		ConcreteUser user2=new ConcreteUser();
		ConcreteUser user3=new ConcreteUser();
		//���۲���ע�ᵽ�ɹ۲����Ĺ۲����б���
		blog.addUser(user1);
		blog.addUser(user2);
		blog.addUser(user3);
		
		blog.notifyChanged("����������,����������");
	}

}
