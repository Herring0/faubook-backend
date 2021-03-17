package com.herring.faubook.entity;

import com.herring.faubook.entity.enums.Gender;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "login", length = 15, unique=true, nullable = false)
    private String login;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "email", length = 60, unique=true, nullable = false)
    @Email(message="Please provide a valid email address")
    private String email;

    @Column(name = "registration_datetime", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private List<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(String name, Gender gender, String login, String password, String email, Date creationDateTime, boolean active, List<RoleEntity> roles) {
        this.name = name;
        this.gender = gender;
        this.login = login;
        this.password = password;
        this.email = email;
        this.creationDateTime = creationDateTime;
        this.active = active;
        this.roles = roles;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
