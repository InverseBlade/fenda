package com.zzw.fenda.po;

import java.sql.Timestamp;

public class Queslist {

    private Integer quesID;

    private Integer giverID;

    private Integer solverID;

    private String quesInfo;

    private Timestamp giveDate;

    private Timestamp solveDate;

    private Integer likeNum;

    private String answer;

    private String audioUrl;

    private Integer listenCount;

    public Integer getQuesID() {
        return quesID;
    }

    public Queslist setQuesID(Integer quesID) {
        this.quesID = quesID;
        return this;
    }

    public Integer getGiverID() {
        return giverID;
    }

    public Queslist setGiverID(Integer giverID) {
        this.giverID = giverID;
        return this;
    }

    public Integer getSolverID() {
        return solverID;
    }

    public Queslist setSolverID(Integer solverID) {
        this.solverID = solverID;
        return this;
    }

    public String getQuesInfo() {
        return quesInfo;
    }

    public Queslist setQuesInfo(String quesInfo) {
        this.quesInfo = quesInfo;
        return this;
    }

    public Timestamp getGiveDate() {
        return giveDate;
    }

    public Queslist setGiveDate(Timestamp giveDate) {
        this.giveDate = giveDate;
        return this;
    }

    public Timestamp getSolveDate() {
        return solveDate;
    }

    public Queslist setSolveDate(Timestamp solveDate) {
        this.solveDate = solveDate;
        return this;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public Queslist setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Queslist setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public Queslist setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
        return this;
    }

    public Integer getListenCount() {
        return listenCount;
    }

    public Queslist setListenCount(Integer listenCount) {
        this.listenCount = listenCount;
        return this;
    }
}
