package com.example.tazo;

public class ChattingData {

    private int profile;
    private String nickName;
    private String chattingText;

    public ChattingData(int profile, String nickName, String chattingText) {
        this.profile = profile;
        this.nickName = nickName;
        this.chattingText = chattingText;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
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
}
