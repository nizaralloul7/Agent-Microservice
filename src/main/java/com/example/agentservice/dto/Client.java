package com.example.agentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client
{
    private Long id;
    private String cin;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String phone;
    private String email;
}
