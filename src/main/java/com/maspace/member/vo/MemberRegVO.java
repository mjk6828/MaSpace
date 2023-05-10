package com.maspace.member.vo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class MemberRegVO {
//    @ApiModelProperty(name = "username", example = "seung")
    @ApiParam(value = "유저 로그인 ID", required = true)
    private String username;
//    @ApiModelProperty(name = "email", example = "mjk6829@gmail.com")
    @ApiParam(value = "유저 이메일", required = true)
    private String email;
//    @ApiModelProperty(name = "password", example = "1234")
    @ApiParam(value = "유저 패스워드", required = true)
    private String password;
//    @ApiModelProperty(name = "remark", example = "관리자계정")
    @ApiParam(value = "유저 코멘트(비고)")
    private String remark;
}
