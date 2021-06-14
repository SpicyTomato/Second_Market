package com.alliance.second_used_translation.domain;

import java.util.Date;

public class Good {
    private Integer id;

    private String name;

    private String category;

    private String size;

    private String repertory;

    private String usedDegree;

    private Date updateAt;

    private String updateBy;

    private String insertBy;

    private Date insertAt;

    private Integer isValid;

    private String goodSnap;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRepertory() {
        return repertory;
    }

    public void setRepertory(String repertory) {
        this.repertory = repertory == null ? null : repertory.trim();
    }

    public String getUsedDegree() {
        return usedDegree;
    }

    public void setUsedDegree(String usedDegree) {
        this.usedDegree = usedDegree == null ? null : usedDegree.trim();
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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

    public String getGoodSnap() {
        return goodSnap;
    }

    public void setGoodSnap(String goodSnap) {
        this.goodSnap = goodSnap == null ? null : goodSnap.trim();
    }
}