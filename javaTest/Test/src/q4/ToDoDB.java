package q4;

import q2.*;
import java.sql.*;

public class ToDoDB {

	public static void main(String[] args) {
		try {
			ToDo[] todos = ToDoFromRemoteJSON.getToDoArray();
			insertIntoDB(todos);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	HeidiSQL, MySQL CLI, PhpAdmin, MySQL Workbench �� ���ϴ� ���α׷��� �̿��� ���̺��� �����ϸ� ��.
	private static void insertIntoDB(ToDo[] todos) throws Exception{
//		   Table ������ ����.   
		
//		  	use oop;
//
//			create table todos (
//   				userId int, 
//   				id int primary key,
//					title varchar(100), 
//					completed bool 
//			); 
		
		
		// ������ DBMS�� ��ϵ� ����� ������ ���� �Ʒ� ������ ���� ������ �����Ͻÿ�. 
		String jdbcDriver = "org.mariadb.jdbc.Driver";  
		String url = "jdbc:mariadb://localhost:3306/OPP";  
		String user = "root";
		String passwd = "root";
		
		Class.forName(jdbcDriver);
		Connection con = DriverManager.getConnection(url, user, passwd);
		
		// ���⿡ �����Ͻÿ�. 
		
		
		
		String sql = "insert into todos(userId, id, title, completed) values(?,?,?,?)";
		PreparedStatement pStmt = con.prepareStatement(sql);
		
		for(ToDo todo : todos)
		{
			pStmt.setInt(1, todo.getUserId());
			pStmt.setInt(2, todo.getId());
			pStmt.setString(3, todo.getTitle());
			pStmt.setBoolean(4, todo.getCompleted());
			
			pStmt.executeUpdate();
		}
		con.close();
		System.out.println("ToDo " + todos.length + "���� �����ͺ��̽��� ���ԵǾ����ϴ�.");
	}

}
