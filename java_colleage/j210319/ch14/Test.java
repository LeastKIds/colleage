package j210319.ch14;

public class Test {
  

    // throws 는 던질 수도 있다
    // throw 는 던진다
    public static void main(String[] args)
    {
        String id="scpark";
        String pw="11112";

        // try
        // {
        //     login(id,pw);
        //     System.out.println("test");
        // } catch(Exception e)
        // {
        //     System.out.println(e.getMessage());
        // }
        
    }

    // 만약 LoginException 일경우는 
    // Student s = new Object() 같은 이야기
    private static void login(String id, String pw) throws Exception 
    {
        // try
        // {
        //     checkDB(id,pw);
        // }catch(Exception e)
        // {
        //     System.out.println(e.getMessage());
        // }

        checkDB(id,pw);
            
    }

    private static void checkDB(String id, String pw) throws Exception
    {
        if(id.equals("scpark") == false)
        {
            throw new LoginIDException("ID Error");
        }
        else if(pw.equals("1111")== false)
        {
            throw new LoginPasswordException("Password Error");
        }
        else
        {
            System.out.println("성공");
        }
    }
}
