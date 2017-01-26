package com.jean.dao.entity.user;

import com.jean.dao.entity.BaseEntityAudit;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jean on 10.01.16.
 */



@Entity
@Table(name = "users")
public class User extends BaseEntityAudit {

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "roles")

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Role> roles;

//    private SocialMediaService socialService;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

/*    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        *//*impl only one role*//*

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }*/

//    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

/*public SocialMediaService getSocialService() {
        return socialService;
    }

    public void setSocialService(SocialMediaService socialService) {
        this.socialService = socialService;
    }*/



    public String getUsername() {
        return email;
    }

/*    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}