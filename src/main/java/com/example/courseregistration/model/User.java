package com.example.courseregistration.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Size(max = 10, message="required")
    @Valid
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Integer age;

}
