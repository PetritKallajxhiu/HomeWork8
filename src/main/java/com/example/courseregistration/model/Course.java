package com.example.courseregistration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "courses")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 4, max = 10)
    private String name;

    @Size(min = 5, max = 20)
    private String description;

    @ManyToOne
    @JoinColumn(name = "registration_id", insertable = false, updatable = false)
//    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Registration registration;

    private Integer registration_id;
}
