package com.zzw.fenda.po;

import java.sql.Timestamp;

public class User {

    private Integer uid;

    private Integer gender;

    private String nickname;

    private String photo;

    private String intro;

    private String phone;

    private String openid;

    private Timestamp joinDate;

    private String honor;

    private Integer answerNum;

    private Integer fansNum;

    public Integer getUid() {
        return uid;
    }

    public User setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public User setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public User setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public String getIntro() {
        return intro;
    }

    public User setIntro(String intro) {
        this.intro = intro;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public User setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    public Timestamp getJoinDate() {
        return joinDate;
    }

    public User setJoinDate(Timestamp joinDate) {
        this.joinDate = joinDate;
        return this;
    }

    public String getHonor() {
        return honor;
    }

    public User setHonor(String honor) {
        this.honor = honor;
        return this;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public User setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
        return this;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public User setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
        return this;
    }
}
