package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/6/19 - 19:07
 */
public class Fight {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer sessionid;
    @Column
    private Integer state;
    @Column
    private String fightname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSessionid() {
        return sessionid;
    }

    public void setSessionid(Integer sessionid) {
        this.sessionid = sessionid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFightname() {
        return fightname;
    }

    public void setFightname(String fightname) {
        this.fightname = fightname;
    }
}
