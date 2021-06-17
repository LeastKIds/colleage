package q2;

public class ToDo {
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	public int getId() {
		return id;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public String toString() {
		return "{userId:"+userId+", id:" + id+", title:" + title+", completed:" + completed+"}";
	}
	
	// 여기에 구현하시오...
}
