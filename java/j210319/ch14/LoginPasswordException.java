package j210319.ch14;

public class LoginPasswordException extends LoginException{
    public LoginPasswordException(String errMsg)
    {
        super(errMsg);
    }

    public LoginPasswordException(String errMsg, int errCode)
    {
        super(errMsg,errCode);
    }
}
