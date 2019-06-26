package com.zzw.fenda.dto;

public class AskListFilter {

    private Integer giverID;

    private Integer solverID;

    private String keyword;

    public Integer getGiverID() {
        return giverID;
    }

    public AskListFilter setGiverID(Integer giverID) {
        this.giverID = giverID;
        return this;
    }

    public Integer getSolverID() {
        return solverID;
    }

    public AskListFilter setSolverID(Integer solverID) {
        this.solverID = solverID;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public AskListFilter setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }
}
