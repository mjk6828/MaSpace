package com.maspace.member.model;

import com.maspace.postgres.BaseTimeEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Member extends BaseTimeEntity {
    @Id
    private String userid;
    private String password;
    @Column(nullable = true, length = 50)
    private String username;
    @Column(unique = true, nullable = false, length = 200)
    private String email;
    @Column(nullable = true, length = 50)
    private String nickname;
    @Column(nullable = true, length = 1)
    private String gender;
    @Column(nullable = true, length = 100)
    private String sns_id;
    @Column(nullable = true, length = 2)
    private String sns_type;

}
