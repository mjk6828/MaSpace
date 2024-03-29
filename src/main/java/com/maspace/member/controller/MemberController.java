package com.maspace.member.controller;

import com.maspace.member.vo.LoginVO;
import com.maspace.member.vo.MemberRegVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

@Slf4j
@Tag(name="로그인", description = "로그인 관리")
@RestController
//@RequestMapping("/api/v0.9")
public class MemberController {

    @GetMapping("/users")
    @Operation(summary = "유저 조회", description = "유저 조회 API")
    public Object Users() {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("msg", "success");
        return result;
    }

    @PostMapping("/login")
    @Operation(summary = "로그인(토큰 발행)", description = "로그인하여 JWT 토큰을 발행하는 API")
    public Object login(Model model, @RequestBody LoginVO vo) {
//        String name = username;
//        String pass = vo.getPassword();
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("username", vo.getUsername());
        result.put("password", vo.getPassword());
        return result;
    }

    @PostMapping("/user")
    @Operation(summary = "유저 등록", description = "유저 등록 API")
    public Object user_reg(@RequestBody MemberRegVO vo) {

        return vo;
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "유저 상세조회", description = "유저 상세조회 API")
    public Object user_detail(@PathVariable String id) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("id", id);

        return result;
    }

    @PutMapping("/user/{id}")
    @Operation(summary = "유저 수정", description = "유저 수정 API")
    public Object user_update(@PathVariable String id) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("id", id);

        return result;
    }

    @DeleteMapping("/user/{id}")
    @Operation(summary = "유저 삭제", description = "유저 삭제 API")
    public Object user_delete(@PathVariable String id) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("id", id);

        return result;
    }

    @GetMapping("/kakao/login")
    @Operation(summary = "카카오 동의항목", description = "카카오 동의항목 API")
    public ResponseEntity<?> kakaoLogin(HttpServletResponse response) throws IOException {
//        OkHttpClient okHttpClient = new OkHttpClient();
//        String url = "https://kauth.kakao.com/oauth/authorize";
        String redirectUrl = "http://localhost:8080/kakao/oauth";
        String kakaoLoginUrl = "https://kauth.kakao.com/oauth/authorize";
        String client_id = "a95991df84a6c8dd50d4597faae9ca1b";
        HttpUrl.Builder httpUrl = HttpUrl.get("https://kauth.kakao.com/oauth/authorize").newBuilder();
                httpUrl.addQueryParameter("client_id", "a95991df84a6c8dd50d4597faae9ca1b");
                httpUrl.addQueryParameter("redirect_uri", redirectUrl);
                httpUrl.addQueryParameter("response_type", "code");
                httpUrl.build();

                String KakaoUrl = httpUrl.toString();
//        Request request = new Request.Builder()
//                .url(httpUrl.build())
//                .build();
        String returnUrl = kakaoLoginUrl+"?client_id="+client_id+"&redirect_uri="+redirectUrl+"&response_type=code";
        log.info("returnUrl : " + returnUrl);
//        Response response = okHttpClient.newCall(request).execute();
//        String responseString = response.body().string();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(KakaoUrl));
//        HashMap<String, String> result = new HashMap<String, String>();
//        result.put("url", returnUrl);
//        response.sendRedirect(returnUrl);

        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/kakao/oauth")
    @Operation(summary = "카카오 로그인", description = "카카오 로그인")
    public void kakaoOauth(
            @RequestParam("code") String code
    ) {

        log.info("code : "+ code);

        System.out.println("oauth");
    }

}
