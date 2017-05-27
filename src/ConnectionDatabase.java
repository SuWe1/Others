

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
			//调用Class.forName()方法加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("can't find mysql connection");
		}
		
		String url="jdbc:mysql://localhost:3306/mydatabase";//JDBC的URL 
		try{
			Connection con=(Connection) DriverManager.getConnection(url,"root","YSW96911?");
			
			Statement statement=(Statement) con.createStatement();
			System.out.println("connect mysql is successful");
			
			//查询数据库
			String sql="select * from mytable;";
			ResultSet set=statement.executeQuery(sql);
			System.out.println("编号"+"\t"+"姓名"+"\t"+"性别");
			while(set.next()){
				System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getInt(3));
				System.out.println();
			}
			
			
			//修改
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
