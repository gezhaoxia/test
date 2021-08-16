package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Time;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:45
 */
public class Session {
    @Id
    @Column
    private Integer id;
    @Column
    private String title;
    @Column
    private String infomation;
    @Column
    private String time;
    @Column
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfomation() {
        return infomation;
    }

    public void setInfomation(String infomation) {
        this.infomation = infomation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
