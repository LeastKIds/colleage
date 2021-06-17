package q3;

import q2.*;
import java.util.*;

public class TodoAnalyser {

	public static void main(String[] args) {
		
		try {
			ToDo[] todos = ToDoFromRemoteJSON.getToDoArray();
			
			Map<Integer, TaskStatus> map = buildTaskStatus(todos);

			printUserTaskStatus(map);

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Map<Integer, TaskStatus> buildTaskStatus (ToDo[] todos) {
		Map<Integer, TaskStatus> map = new HashMap<>();
		// 여기에 구현하시오.
		
		
		return map;
	}
	
	public static void printUserTaskStatus(Map<Integer, TaskStatus> map) {
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			TaskStatus ts = map.get(key);
			System.out.println("userId(" +key+ ") : "  + "competed(" + ts.getCompletedCnt() +
										"), uncompleted(" + ts.getUnCompletedCnt()+")");
		}
	}
}
