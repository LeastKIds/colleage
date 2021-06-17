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
		String jdbcDriver = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/OPP";
		String user = "root";
		String passwd = "root";
		
		Class.forName(jdbcDriver);
		Connection con = DriverManager.getConnection(url, user, passwd);
		
		// �� ���ڵ忡 ���� ToDo��ü ������ list�� �߰�.
		// ���⿡ �����Ͻÿ�. 
		
		
		
		for(int i=0; i<200; i++)
		{
			ToDo todo = new ToDo();
			
			
			String sql="select userId, id, title, completed from todos where id =" + (i+1);
			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs=pStmt.executeQuery();
			
			
			
			
			todo.setUserId(rs.getInt("userId"));
			todo.setId(rs.getInt("id"));
			todo.setTitle(rs.getString("title"));
			todo.setCompleted(rs.getBoolean("completed"));
			
			list.add(todo);
		}
		
		
		con.close();
		return list;
	}

}
