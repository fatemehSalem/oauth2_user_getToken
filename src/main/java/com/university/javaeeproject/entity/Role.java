package com.university.javaeeproject.entity;

import com.university.javaeeproject.util.RoleType;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

//@ToString
@Entity(name = "ROLE")
//@Table(name = "ROLE")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private long id;

    @Column(name = "NAME")
    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleType roleName;

    @Column(name = "DESCRIPTION")
    private String description;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleType getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleType roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
