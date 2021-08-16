package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:47
 */
public class Session_condidate {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer sessionId;
    @Column
    private Integer condidateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getCondidateId() {
        return condidateId;
    }

    public void setCondidateId(Integer condidateId) {
        this.condidateId = condidateId;
    }
}
