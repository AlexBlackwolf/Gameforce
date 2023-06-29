package com.example.Gamefroce.entity;

import jakarta.persistence.Entity;

@Entity
public class AuditableEntity {
    private String createdOn;
    private String createBy;
    private String modifyBy;
    private String modifyOn;



    private Boolean deleted;


    public AuditableEntity(String createdOn, String createBy, String modifyBy, String modifyOn, Boolean deleted) {
        this.createdOn = createdOn;
        this.createBy = createBy;
        this.modifyBy = modifyBy;
        this.modifyOn = modifyOn;
        this.deleted = deleted;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(String modifyOn) {
        this.modifyOn = modifyOn;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
