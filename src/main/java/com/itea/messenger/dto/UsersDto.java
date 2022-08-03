package com.itea.messenger.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UsersDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
    private Long photoId;
    private String login;
    private int age;
    private double lastLoginDate;
}