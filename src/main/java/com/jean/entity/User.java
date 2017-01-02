package com.jean.entity;

import java.util.List;

/*@Entity
@Table(name="APP_USER")*/
public class User {
/*    @Id @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

//    @Column(name="username")
    private String username;

//    @Column(name="password")
    private String password;

/*    @OneToMany
    @JoinColumn(name="APP_USER_ID", referencedColumnName="ID")*/
    private List<UserRole> roles;

    public User() { }

    public User(Long id, String username, String password, List<UserRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }
}