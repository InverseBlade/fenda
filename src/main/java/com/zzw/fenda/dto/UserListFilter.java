package com.zzw.fenda.dto;

public class UserListFilter {

    private String nickname;

    private String keyword;

    private String honor;

    public String getNickname() {
        return nickname;
    }

    public UserListFilter setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public UserListFilter setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getHonor() {
        return honor;
    }

    public UserListFilter setHonor(String honor) {
        this.honor = honor;
        return this;
    }
}
