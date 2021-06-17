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
	
	public void setUserId(int userId)
	{
		this.userId=userId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	public String getTitle()
	{
		return title;
	}
	
	public void setCompleted(boolean completed)
	{
		this.completed=completed;
	}
	
	public boolean getCompleted()
	{
		return completed;
	}
	
}
