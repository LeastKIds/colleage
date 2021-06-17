package q1;

public class Student {
	private String stdId;  // 학번
	private String name;   // 이름
	private String hakban; // 학반
	private String hakneon; // 학년
	private String gender;  // 성별
	private String dept;    // 소속계열/학과
	
	public String toString() {
		return "[" + stdId + ", " + name + ", " + hakban + ", " + hakneon + ", " +
					gender + ", " + dept +"]";
	}
	
	// 여기에 구현하시오...
	
	public void setStdId(String stdId)
	{
		this.stdId = stdId;
	}
	public String getStdId()
	{
		return stdId;
	}
	public void setName(String Name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setHackban(String hackban)
	{
		this.hakban = hakban;
	}
	public String getHackban()
	{
		return hakban;
	}
	public void setHakneon(String hakneon)
	{
		this.hakneon = hakneon;
	}
	public String getHakneon()
	{
		return hakneon;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getGender()
	{
		return gender;
	}
	
	public void setDept(String dept)
	{
		this.dept=dept;
	}
	
	public String get()
	{
		return dept;
	}
}
