package com.zzw.fenda.dto;

public class UserListDTO {

    private Integer uid;

    private Integer gender;

    private String nickname;

    private String photo;

    private String honor;

    public Integer getUid() {
        return uid;
    }

    public UserListDTO setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserListDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserListDTO setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public UserListDTO setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getHonor() {
        return honor;
    }

    public UserListDTO setHonor(String honor) {
        this.honor = honor;
        return this;
    }
}
