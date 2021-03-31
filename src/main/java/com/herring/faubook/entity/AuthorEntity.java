package com.herring.faubook.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "authors")
public class AuthorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 120)
    private String name;

    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Column(name = "dod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dod;

    @Column(name = "bio", length = 8192)
    private String bio;

    public AuthorEntity() {
    }

    public AuthorEntity(String name, Date dob, Date dod, String bio) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.bio = bio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
