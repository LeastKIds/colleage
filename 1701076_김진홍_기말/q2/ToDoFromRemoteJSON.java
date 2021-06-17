package q2;

import java.net.*;
import java.io.*;
import com.google.gson.*;

public class ToDoFromRemoteJSON {
	public static final String SITE = "https://jsonplaceholder.typicode.com/todos";
	
	
	public static void main(String[] args) throws Exception {
		ToDo[] todos = getToDoArray();
	
		for (ToDo todo : todos) {
			System.out.println(todo.getId() + " : " + todo.isCompleted());
		}
	}

	public static ToDo[] getToDoArray() throws Exception {
		ToDo[] todos = null;
		URL url = new URL(SITE);
		// SITE�� ������ �� ����Ʈ�� �����ִ� json ���ڿ��� �Է½�Ʈ���� ��� �д´�.
		// ���� json ���ڿ��κ��� ToDo[] �� ������ ��ȯ.  <= Gson ���̺귯�� �̿�
		
		// ���⿡ �����Ͻÿ�...
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("USER-Agent", "Mozilla/5.0");
		
		BufferedReader in =new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer output = new StringBuffer();
		while((inputLine = in.readLine()) != null)
		{
			output.append(inputLine);
		}
//		System.out.println(output);
		
		Gson gson=new Gson();
		
		todos=gson.fromJson(output.toString(), ToDo[].class);
		
		
		return todos;
	}
	
}
