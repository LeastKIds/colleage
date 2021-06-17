package q5;

import java.sql.*;
import q2.ToDo;
import java.util.*;

public class ToDoFromDB {

	public static void main(String[] args) {
		try {
			ArrayList<ToDo> list = buildToDoListFromDB();
			for (ToDo todo: list) {
				System.out.println(todo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<ToDo> buildToDoListFromDB() throws Exception{
		
		ArrayList<ToDo> list = new ArrayList<>();
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/OOP";
		String user = "root";
		String passwd = "1111";
		
		Class.forName(jdbcDriver);
		Connection con = DriverManager.getConnection(url, user, passwd);
		
		// 각 레코드에 대해 ToDo객체 생성해 list에 추가.
		// 여기에 구현하시오. 
		
		
		con.close();
		return list;
	}

}
