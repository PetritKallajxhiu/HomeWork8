package com.example.courseregistration.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "registration")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(min = 4, max = 10)
    private String name;

    @OneToMany(mappedBy = "registration")
    @NotNull
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Set<Course> courses = new HashSet<>();

}
