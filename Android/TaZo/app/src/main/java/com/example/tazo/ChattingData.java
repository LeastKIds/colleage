package com.example.tazo;

public class ChattingData {

    private String profile;
    private String nickName;
    private String chattingText;
    private String myName;
    private int inOut;

    public ChattingData(String profile, String nickName, String chattingText, String myName, int inOut) {
        this.profile = profile;
        this.nickName = nickName;
        this.chattingText = chattingText;
        this.myName = myName;
        this.inOut = inOut;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getChattingText() {
        return chattingText;
    }

    public void setChattingText(String chattingText) {
        this.chattingText = chattingText;
    }

    public void setMyName(String myName) { this.myName = myName; }

    public String getMyName() { return myName; }

    public void setInOut(int inOut) { this.inOut = inOut; }

    public int getInOut() { return inOut; }
}
