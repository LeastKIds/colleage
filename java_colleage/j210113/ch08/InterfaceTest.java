package j210113.ch08;

public class InterfaceTest implements MyInterface{

    @Override
    public void test1() {
        // TODO Auto-generated method stub

    }

    @Override
    public void test2() {
        // TODO Auto-generated method stub

    }

    @Override
    public void test3() {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args)
    {
        InterfaceTest it=new InterfaceTest();
        MyInterface it2=new InterfaceTest();
        //MyInterface it3=new MyInterface(); 인터페이스 타입의 클래스는 만들 수 없다
        
    }
    
}
