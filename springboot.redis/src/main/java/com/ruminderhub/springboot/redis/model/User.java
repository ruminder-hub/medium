package com.ruminderhub.springboot.redis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String city;
}
