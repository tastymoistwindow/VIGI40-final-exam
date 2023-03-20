package com.exam.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class AddPlayerDTO {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private LocalDate playStartDate;
}
