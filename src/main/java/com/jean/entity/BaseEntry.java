package com.jean.entity;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * Created by jean on 01.01.17.
 */

@Entity
public abstract class BaseEntry {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 6, nullable = false)
    protected long id;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
