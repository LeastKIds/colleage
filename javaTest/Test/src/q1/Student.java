package q1;

public class Student {
	private String stdId;  // �й�
	private String name;   // �̸�
	private String hakban; // �й�
	private String hakneon; // �г�
	private String gender;  // ����
	private String dept;    // �ҼӰ迭/�а�
	
	public String toString() {
		return "[" + stdId + ", " + name + ", " + hakban + ", " + hakneon + ", " +
					gender + ", " + dept +"]";
	}
	
	// ���⿡ �����Ͻÿ�...
	
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
