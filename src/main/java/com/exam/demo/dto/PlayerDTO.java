package com.exam.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private LocalDate playStartDate;

    private String sex;

    private int age;

    private String playerExperience;

    public void setPlayerExperience(String playerExperience) {

        try {
            String years = String.valueOf(Period.between(playStartDate, LocalDate.now()).getYears());
            String months = String.valueOf(Period.between(playStartDate, LocalDate.now()).getMonths());

            if (months.equals("0")) {
                playerExperience = years + " years";
            }
            if (years.equals("0"))
                playerExperience = months + " months";
            else
                playerExperience = years + " years, " + months + " months";

            this.playerExperience = playerExperience;
        } catch (NullPointerException ne) {
            this.playerExperience = "Experience unknown";
        }
    }

    public void setSex(String sex) {

        if (String.valueOf(id).startsWith("3") || String.valueOf(id).startsWith("5")) {
            this.sex = "Male";
        } else if (String.valueOf(id).startsWith("4") || String.valueOf(id).startsWith("6")) {
            this.sex = "Female";
        } else this.sex = "Sex not provided";


        // bandziau padaryti, kad kai age=0 (suvedus nesamoninga id pvz. 333333333333), rodytu "Sex not provided"
        // bet else-if nei su getAge()==0 , nei age==0 neveike  - jei gali pakomentuok kaip tai galeciau aprasyti, aciu.
    }


    public void setAge(int age) {

        String s = id.toString().substring(1, 7);
        StringBuilder sb = new StringBuilder(s);

        try {
            if (String.valueOf(id).startsWith("3") || String.valueOf(id).startsWith("4")) {

                sb.insert(2, "/");
                sb.insert(5, "/");
                s = sb.insert(0, "19").toString();

            } else if (String.valueOf(id).startsWith("5") || String.valueOf(id).startsWith("6")) {

                sb.insert(2, "/");
                sb.insert(5, "/");
                s = sb.insert(0, "20").toString();

            }

            LocalDate dob = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

            this.age = Integer.parseInt(String.valueOf(Period.between(dob, LocalDate.now()).getYears()));
        } catch (DateTimeException dte) {
            this.age = 0;
        }

    }

}
