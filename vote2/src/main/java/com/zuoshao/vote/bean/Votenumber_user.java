package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:49
 */
public class Votenumber_user {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer votenumberId;
    @Column
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVotenumberId() {
        return votenumberId;
    }

    public void setVotenumberId(Integer votenumberId) {
        this.votenumberId = votenumberId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
