

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ConnectionDatabase {

	public ConnectionDatabase() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			//����Class.forName()����������������
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("can't find mysql connection");
		}
		
		String url="jdbc:mysql://localhost:3306/mydatabase";//JDBC��URL 
		try{
			Connection con=(Connection) DriverManager.getConnection(url,"root","YSW96911?");
			
			Statement statement=(Statement) con.createStatement();
			System.out.println("connect mysql is successful");
			
			//��ѯ���ݿ�
			String sql="select * from mytable;";
			ResultSet set=statement.executeQuery(sql);
			System.out.println("���"+"\t"+"����"+"\t"+"�Ա�");
			while(set.next()){
				System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getInt(3));
				System.out.println();
			}
			
			
			//�޸�
			String sqlUpdate="update mytable set name=? where id=?";
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement(sqlUpdate);
			
			
			set.close();
			statement.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
