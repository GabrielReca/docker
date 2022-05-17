package com.example.docker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado implements Serializable {

    private String Id;
    private String Name;
    private String Email;
    private String Address;
}
