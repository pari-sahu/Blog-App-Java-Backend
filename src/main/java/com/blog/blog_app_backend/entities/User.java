package com.blog.blog_app_backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails; // <--- MAKE SURE THIS IMPORT IS PRESENT

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
// *** THIS IS THE CRITICAL CHANGE YOU NEED TO MAKE ***
public class User implements UserDetails { // <-- Add 'implements UserDetails' here

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;

    @Column(unique = true)
    private String email;

    private String password; // Spring Security expects a getPassword() method (Lombok handles this)

    private String about;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // This maps your User's roles to Spring Security's GrantedAuthority
        List<SimpleGrantedAuthority> authories = this.roles.stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return authories;
    }

    @Override
    public String getUsername() {
        // Spring Security uses this to get the user's principal (usually email or username)
        return this.email;
    }


    @Override
    public boolean isAccountNonExpired() {
        // Return true if the account is not expired. You can add custom logic here.
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return true if the account is not locked. You can add custom logic here.
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return true if the credentials (password) are not expired. You can add custom logic here.
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return true if the user is enabled. You can add custom logic here (e.g., for email verification).
        return true;
    }
}