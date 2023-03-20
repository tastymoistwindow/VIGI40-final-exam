package com.exam.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Player {

    @Id
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private LocalDate playStartDate;

}