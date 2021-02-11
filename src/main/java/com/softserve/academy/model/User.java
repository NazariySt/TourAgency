package com.softserve.academy.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName", nullable = false)
    private String firstName;


    @Column(name = "lastName", nullable = false)
    private String lastName;


    @Column(name = "emailLogin", nullable = false, unique = true)
    private String emailLogin;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated
    private Role role;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> bookings = new ArrayList<>();

    public User(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailLogin = login;
        this.password = password;
    }
    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.name()));
        return grantedAuthorities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmailLogin() {
        return emailLogin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.emailLogin = login;
    }

    public List<Order> getBookings() {
        return bookings;
    }

    public void setBookings(List<Order> bookings) {
        this.bookings = bookings;
    }

                        /* Overrides methods from UserDetails   */
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(id);
    }

    @Override
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
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User {" +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", email = '" + emailLogin + '\'' +
                ", password = '" + password + '\'' +
                ", role = " + role +
                "} ";
    }

}
