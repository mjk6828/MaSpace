package com.maspace.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member {
    @Id
    private String userid;

    private String password;

    private String email;
}
