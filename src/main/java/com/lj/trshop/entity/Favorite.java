package com.lj.trshop.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Favorite implements Serializable {
    private Integer rid;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;
    private Integer uid;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "rid=" + rid +
                ", date=" + date +
                ", uid=" + uid +
                '}';
    }
}
