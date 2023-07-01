package com.example.Gameforce.entity;

import jakarta.persistence.*;


@MappedSuperclass
//class needs to be abstract to avoid to be inizialized as a table
public abstract class AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String createdOn;
    private String createBy;
    private String modifiedBy;
    private String modifiedOn;
    private Boolean deleted;


    public AuditableEntity(Long id, String createdOn, String createBy, String modifyBy, String modifyOn) {
        this.createdOn = createdOn;
        this.createBy = createBy;
        this.modifiedBy = modifyBy;
        this.modifiedOn = modifyOn;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return modifiedBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifiedBy = modifyBy;
    }

    public String getModifyOn() {
        return modifiedOn;
    }

    public void setModifyOn(String modifyOn) {
        this.modifiedOn = modifyOn;
    }
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
