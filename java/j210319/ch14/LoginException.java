package j210319.ch14;


// throws Exception 대신에 throws LoginException 을 사용 가능
public class LoginException extends Exception{
    private int errorCode;
    public LoginException(String errMsg)
    {
        super(errMsg);
    }

    public LoginException(String errMsg, int errorCode)
    {
        super(errMsg);
        this.errorCode=errorCode;

    }

    public int getErrorCode()
    {
        return errorCode;
    }
}
