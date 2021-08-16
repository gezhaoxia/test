package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/6/19 - 19:09
 */
public class Fight_condidate {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer condidateid;
    @Column
    private Integer fightid;
    @Column
    private Integer win;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCondidateid() {
        return condidateid;
    }

    public void setCondidateid(Integer condidateid) {
        this.condidateid = condidateid;
    }

    public Integer getFightid() {
        return fightid;
    }

    public void setFightid(Integer fightid) {
        this.fightid = fightid;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }
}
