package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:24
 */
public class Votenumber {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer state;
    @Column
    private Integer sessionid;
    @Column
    private Integer condidateid;
    @Column
    private Integer userid ;
    @Column
    private Integer fightid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSessionid() {
        return sessionid;
    }

    public void setSessionid(Integer sessionid) {
        this.sessionid = sessionid;
    }

    public Integer getCondidateid() {
        return condidateid;
    }

    public void setCondidateid(Integer condidateid) {
        this.condidateid = condidateid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFightid() {
        return fightid;
    }

    public void setFightid(Integer fightid) {
        this.fightid = fightid;
    }
}
