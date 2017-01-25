package com.jean.dao.entity;

import com.jean.dao.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;




/**
 * Created by jean on 07.01.17.
 */
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {


    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @Column(name = "created_by", length = 20)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


    @Column(name = "updated_by", length = 20)
    private String updatedBy;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();
    }


    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }
}
