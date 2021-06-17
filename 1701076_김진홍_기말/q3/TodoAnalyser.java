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
		
		
		for (ToDo todo : todos)
		{
			TaskStatus taskStatus = new TaskStatus();
			
			for(int i=0; i<20; i++)
			{
				if(todo.getCompleted() == true)
					taskStatus.incrementCompeted();
				else
					taskStatus.incrementUnCompleted();
			}
			
			map.put(todo.getUserId(), taskStatus);
			
					
		}
		
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
