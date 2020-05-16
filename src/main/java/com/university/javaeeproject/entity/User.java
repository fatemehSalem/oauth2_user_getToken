package com.university.javaeeproject.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@DynamicUpdate
@Entity
@Table(name = "USER")
public class User implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    @NotBlank(message = "firstName can not be blank")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotBlank(message = "lastName can not be blank")
    private String lastName;

    @Column(name = "USERNAME")
    @NotBlank(message = "username can not be blank")
    private String username;

    @Column(name = "PASSWORD")
    @NotBlank(message = "password can not be blank")
    private String password;

    @Column(name = "EMAIL")
    @NotBlank(message = "email can not be blank")
    private String email;

    @Column(name = "COURSE")
    private Long courseId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
    private Set<Role> roles = new HashSet<>();



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        getRoles().forEach(role -> {
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getDescription()));
        });
        return  grantedAuthorityList;
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

}