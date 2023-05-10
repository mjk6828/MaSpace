package com.maspace.member.vo;

import lombok.Data;

import java.util.Date;

@Data
public class MemberVO {
    private int id;
    private String username;
    private String email;
    private String password;
    private Date last_login;
    private Date reg_date;
    private String remark;
}
