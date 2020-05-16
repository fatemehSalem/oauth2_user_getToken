package com.university.javaeeproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "WORKSHOP")
public class WorkShop {
    @Id
    @Column(name = "WORKSHOP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WORKSHOP_SEQ")
    @SequenceGenerator(name = "WORKSHOP_SEQ")
    private Long id;

    @Column(name = "NAME")
    @NotBlank(message = "name can not be blank")
    private String name;

    @Column(name = "DEAD_LINE_TIME")
    @NotBlank(message = "deadLineTime can not be blank")
    private Timestamp deadLineTime;

    @Column(name = "CREATED_BY")
    @NotBlank(message = "createdBy can not be blank")
    private Timestamp createdBy;

    @Column(name = "CREATED_AT")
    @NotBlank(message = "createdAt can not be blank")
    private Timestamp createdAt;

    @Column(name = "MODIFIED_AT")
    private Timestamp modifiedAt;

    @Column(name = "MODIFIED_BY")
    private Long modifiedBy;

    @Column(name = "QUESTION")
    @NotBlank(message = "question can not be blank")
    @ElementCollection(targetClass=String.class)
    private List<String> questions;
}
