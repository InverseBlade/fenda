package com.zzw.fenda.dto;

public class UserBasicDTO {

    private Integer uid;

    private Integer gender;

    private String nickname;

    private String photo;

    private String honor;

    private Integer answerNum;

    private Integer fansNum;

    private String intro;

    public Integer getUid() {
        return uid;
    }

    public UserBasicDTO setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserBasicDTO setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserBasicDTO setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public UserBasicDTO setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getHonor() {
        return honor;
    }

    public UserBasicDTO setHonor(String honor) {
        this.honor = honor;
        return this;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public UserBasicDTO setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
        return this;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public UserBasicDTO setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
        return this;
    }

    public String getIntro() {
        return intro;
    }

    public UserBasicDTO setIntro(String intro) {
        this.intro = intro;
        return this;
    }
}
