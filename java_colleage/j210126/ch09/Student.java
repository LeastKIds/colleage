package j210126.ch09;

public class Student extends Person, Teacher implements Compareable{
    private int gpa;
    private String name;
    private int sid;

    public Student(int gpa, String name, int sid) {
        this.setGpa(gpa);
        this.setName(name);
        this.setSid(sid);
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Studuent [gpa=" + gpa + ", name=" + name + ", sid=" + sid + "]";
    }

    @Override
    public int compareTo(Object o) {
        /*
            Object와 값을 비교해서
            내가 가진 값이 더 크면 양수를 리턴
            같으면 0을 리턴
            작으면 음수를 리턴...
        */

        if(o instanceof Studuent)
        {
            Studuent s=(Studuent)o;
            //return this.gpa - s.gpa;
            return this.name.compareTo(s.name);
        }
        return 0;
    }
    
}
