package com.maspace.controller;

import com.maspace.vo.LoginVO;
import com.maspace.vo.UserRegVO;
import com.maspace.vo.UserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class UserController {

    @GetMapping("/users")
    @ApiOperation(value = "유저 조회", notes = "유저 조회 API")
    public Object Users() {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("msg", "success");
        return result;
    }

    @PostMapping("/login")
    @ApiOperation(value = "로그인(토큰 발행)", notes = "로그인하여 JWT 토큰을 발행하는 API")
    public Object login(Model model, @RequestBody LoginVO vo) {
//        String name = username;
//        String pass = vo.getPassword();
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("username", vo.getUsername());
        result.put("password", vo.getPassword());
        return result;
    }

    @PostMapping("/user")
    @ApiOperation(value = "유저 등록", notes = "유저 등록 API")
//    @ApiImplicitParams({
//            @ApiImplicitParam(
//                    name = "username", value = "로그인아이디", required = true, dataType = "string"
//            ),
//            @ApiImplicitParam(
//                    name = "email", value = "유저 이메일", required = true, dataType = "string"
//            ),
//            @ApiImplicitParam(
//                    name = "password", value = "유저 비밀번호", required = true, dataType = "string"
//            ),
//            @ApiImplicitParam(
//                    name = "remark", value = "비고", required = false, dataType = "string", defaultValue = ""
//            )
//    })
    public Object user_reg(@RequestBody UserRegVO vo) {

        return vo;
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "유저 상세조회", notes = "유저 상세조회 API")
    @ApiImplicitParam(name = "id", value = "유저 ID") // Swagger 에 사용하는 파라미터에 대한 설명
    public Object user_detail(@PathVariable String id) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("id", id);

        return result;
    }

    @PutMapping("/user/{id}")
    @ApiOperation(value = "유저 수정", notes = "유저 수정 API")
    @ApiImplicitParam(name = "id", value = "유저 ID")
    public Object user_update(@PathVariable String id) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("id", id);

        return result;
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "유저 삭제", notes = "유저 삭제 API")
    @ApiImplicitParam(name = "id", value = "유저 ID")
    public Object user_delete(@PathVariable String id) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("id", id);

        return result;
    }

}
