package com.maspace.member.vo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class MemberRegVO {
    @Schema(description = "유저 로그인 ID", required = true)
    private String username;
    @Schema(description = "유저 이메일", required = true)
    private String email;
    @Schema(description = "유저 패스워드", required = true)
    private String password;
    @Schema(description = "유저 코멘트(비고)")
    private String remark;
}
