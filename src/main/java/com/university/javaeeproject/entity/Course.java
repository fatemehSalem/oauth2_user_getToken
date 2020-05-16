package com.university.javaeeproject.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @Column(name = "COURSE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQ")
    @SequenceGenerator(name = "COURSE_SEQ")
    private Long id;

    @Column(name = "NAME")
    @NotBlank(message = "name can not be blank")
    private String name;

    @Column(name = "START_DATE_TIME")
    @NotBlank(message = "starDateTime can not be blank")
    private Timestamp starDateTime;

    @Column(name = "END_DATE_TIME")
    @NotBlank(message = "endDateTime can not be blank")
    private Timestamp endDateTime;

    @Column(name = "DESCRIPTION")
    private String description;


}
