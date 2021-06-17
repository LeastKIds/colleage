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
		// SITE에 접속해 그 사이트가 보내주는 json 문자열을 입력스트림을 열어서 읽는다.
		// 읽은 json 문자열로부터 ToDo[] 를 생성해 반환.  <= Gson 라이브러리 이용
		
		// 여기에 구현하시오...
		
		
		return todos;
	}
}
