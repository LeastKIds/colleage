package j210125.ch09;

public interface Employable {
    String getName();
    static boolean isEmpty(String str)
    {
        // if(str=null || (str.trim().length==0))  // trim 앞 뒤 공백 없애기
        //     return true;
        
        return false;
    }
}
