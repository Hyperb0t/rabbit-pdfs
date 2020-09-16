package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Passport implements Serializable {
    private String name;
    private String surname;
    private Integer age;
    private Integer passportSeries;
    private Integer passportNumber;
    private Date passportGiven;
}
