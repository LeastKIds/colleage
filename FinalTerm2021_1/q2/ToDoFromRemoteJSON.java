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
		
		
		return todos;
	}
}
