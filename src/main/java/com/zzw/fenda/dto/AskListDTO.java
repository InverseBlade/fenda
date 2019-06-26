package com.zzw.fenda.dto;

public class AskListDTO {

    private Integer quesID;

    private Integer giverID;

    private Integer solverID;

    private String giverAvatar;

    private String solverAvatar;

    private String quesInfo;

    private String giveDate;

    private String solveDate;

    private String audioUrl;

    private Integer likeNum;

    private String giverNickname;

    private String solverNickname;

    public Integer getQuesID() {
        return quesID;
    }

    public AskListDTO setQuesID(Integer quesID) {
        this.quesID = quesID;
        return this;
    }

    public Integer getGiverID() {
        return giverID;
    }

    public AskListDTO setGiverID(Integer giverID) {
        this.giverID = giverID;
        return this;
    }

    public Integer getSolverID() {
        return solverID;
    }

    public AskListDTO setSolverID(Integer solverID) {
        this.solverID = solverID;
        return this;
    }

    public String getGiverAvatar() {
        return giverAvatar;
    }

    public AskListDTO setGiverAvatar(String giverAvatar) {
        this.giverAvatar = giverAvatar;
        return this;
    }

    public String getSolverAvatar() {
        return solverAvatar;
    }

    public AskListDTO setSolverAvatar(String solverAvatar) {
        this.solverAvatar = solverAvatar;
        return this;
    }

    public String getQuesInfo() {
        return quesInfo;
    }

    public AskListDTO setQuesInfo(String quesInfo) {
        this.quesInfo = quesInfo;
        return this;
    }

    public String getGiveDate() {
        return giveDate;
    }

    public AskListDTO setGiveDate(String giveDate) {
        this.giveDate = giveDate;
        return this;
    }

    public String getSolveDate() {
        return solveDate;
    }

    public AskListDTO setSolveDate(String solveDate) {
        this.solveDate = solveDate;
        return this;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public AskListDTO setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public AskListDTO setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
        return this;
    }

    public String getGiverNickname() {
        return giverNickname;
    }

    public AskListDTO setGiverNickname(String giverNickname) {
        this.giverNickname = giverNickname;
        return this;
    }

    public String getSolverNickname() {
        return solverNickname;
    }

    public AskListDTO setSolverNickname(String solverNickname) {
        this.solverNickname = solverNickname;
        return this;
    }
}
