package com.example.testinterview.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Beneficiary extends BaseModel{

    private String firstName;

    private String lastName;
}
