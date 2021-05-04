package j210126.ch09;

public class Person {
    private String phone;
    private String addr;

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void eat()
    {
        System.out.println("학생은 먹습니다.");
    }

}
