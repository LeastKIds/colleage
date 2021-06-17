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
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";  
		String url = "jdbc:mysql://localhost:3306/OOP";  
		String user = "root";
		String passwd = "1111";
		
		Class.forName(jdbcDriver);
		Connection con = DriverManager.getConnection(url, user, passwd);
		
		// ���⿡ �����Ͻÿ�. 
		
		
		con.close();
		System.out.println("ToDo " + todos.length + "���� �����ͺ��̽��� ���ԵǾ����ϴ�.");
	}

}
