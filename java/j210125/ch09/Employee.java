package j210125.ch09;

public class Employee implements Employable{
    private String name;

    public Employee(String name)
    {
        if(Employable.isEmpty(name))
        {
            throw new RuntimeException("이름을 반드시 입력하여야 합니다."); // 원래는 try, catch가 있어야 되는데 runtimeException의 경우 예외
        }

        this.name=name;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args)
    {
        Employee e1=new Employee("홍길동");
        System.out.println(e1.getName());

        Employee e2=new Employee("");
        System.out.println(e2.getName());
    }
    
}
