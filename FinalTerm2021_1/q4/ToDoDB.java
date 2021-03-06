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
	
//	HeidiSQL, MySQL CLI, PhpAdmin, MySQL Workbench 등 원하는 프로그램을 이용해 테이블을 생성하면 됨.
	private static void insertIntoDB(ToDo[] todos) throws Exception{
//		   Table 생성문 참고.   
		
//		  	use oop;
//
//			create table todos (
//   				userId int, 
//   				id int primary key,
//					title varchar(100), 
//					completed bool 
//			); 
		
		
		// 연결할 DBMS와 등록된 사용자 정보에 따라 아래 변수의 값을 적절히 변경하시오. 
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";  
		String url = "jdbc:mysql://localhost:3306/OOP";  
		String user = "root";
		String passwd = "1111";
		
		Class.forName(jdbcDriver);
		Connection con = DriverManager.getConnection(url, user, passwd);
		
		// 여기에 구현하시오. 
		
		
		con.close();
		System.out.println("ToDo " + todos.length + "개가 데이터베이스에 삽입되었습니다.");
	}

}
