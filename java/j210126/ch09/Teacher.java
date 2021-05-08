package j210126.ch09;

public class Teacher {
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(String subject)
    {
        this.subject=subject;
    }

    public void eat()
    {
        System.out.println("선생님이 식사를 합니다.");
    }
}
