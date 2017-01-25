package com.jean.dao.entity.user;

import com.jean.dao.entity.BaseEntityAudit;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntityAudit {


    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
