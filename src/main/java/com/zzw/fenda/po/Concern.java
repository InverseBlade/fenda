package com.zzw.fenda.po;

import java.sql.Timestamp;

public class Concern {

    private Integer viewer;

    private Integer blogger;

    private Timestamp concernDate;

    public Integer getViewer() {
        return viewer;
    }

    public Concern setViewer(Integer viewer) {
        this.viewer = viewer;
        return this;
    }

    public Integer getBlogger() {
        return blogger;
    }

    public Concern setBlogger(Integer blogger) {
        this.blogger = blogger;
        return this;
    }

    public Timestamp getConcernDate() {
        return concernDate;
    }

    public Concern setConcernDate(Timestamp concernDate) {
        this.concernDate = concernDate;
        return this;
    }
}
