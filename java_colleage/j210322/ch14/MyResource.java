package j210322.ch14;

public class MyResource implements AutoCloseable{

    public int getValue() throws Exception
    {
        int val=(int)Math.random()*2;
        if (val==1) return val;
        else throw new Exception("오류가 발생했지 뭐야...");
    }
    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("MyResource closed...");
    }
    
}
