package com.zuoshao.vote.bean;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author zuoshao
 * @date 2019/6/15 - 15:42
 */
public class Condidate {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String discrible;
    @Column
    private String image;
    @Column
    private int adduserid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscrible() {
        return discrible;
    }

    public void setDiscrible(String discrible) {
        this.discrible = discrible;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAdduserid() {
        return adduserid;
    }

    public void setAdduserid(int adduserid) {
        this.adduserid = adduserid;
    }
}
