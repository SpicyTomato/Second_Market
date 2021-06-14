package com.alliance.second_used_translation.domain;

import java.util.Date;

public class Merchant {
    private Integer id;

    private String name;

    private String gender;

    private String shopCardSnap;

    private String idCardSnap;

    private String updateBy;

    private Date updateAt;

    private String insertBy;

    private Date insertAt;

    private Integer isValid;

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
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getShopCardSnap() {
        return shopCardSnap;
    }

    public void setShopCardSnap(String shopCardSnap) {
        this.shopCardSnap = shopCardSnap == null ? null : shopCardSnap.trim();
    }

    public String getIdCardSnap() {
        return idCardSnap;
    }

    public void setIdCardSnap(String idCardSnap) {
        this.idCardSnap = idCardSnap == null ? null : idCardSnap.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy == null ? null : insertBy.trim();
    }

    public Date getInsertAt() {
        return insertAt;
    }

    public void setInsertAt(Date insertAt) {
        this.insertAt = insertAt;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}