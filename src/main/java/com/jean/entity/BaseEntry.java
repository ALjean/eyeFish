package com.jean.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jean on 01.01.17.
 */

//@Entity
@MappedSuperclass
public abstract class BaseEntry implements Serializable {

    @Id
    @Basic(optional = false)
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
