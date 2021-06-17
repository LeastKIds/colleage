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
}
