package com.ssafy.controller;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;
import com.ssafy.service.JwtService;
import com.ssafy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    private final UserService service;
    private final JwtService jwtService;

    @Autowired
    public UserController(UserService service, JwtService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto dto) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        log.info("로그인 시도됨");
        try {
            User user = service.loginProcess(dto);
            log.info(user.getUserId());
            if (user != null) {
                String accessToken = jwtService.createAccessToken("userid", user.getUserId());
                String refreshToken = jwtService.createRefreshToken("userid", user.getUserId());
                service.saveRefreshToken(user.getUserId(), refreshToken);
                log.debug("로그인 accessToken 정보 : {}", accessToken);
                log.debug("로그인 refreshToken 정보 : {}", refreshToken);
                resultMap.put("access-token", accessToken);
                resultMap.put("refresh-token", refreshToken);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } else {
                resultMap.put("message", FAIL);
                status = HttpStatus.ACCEPTED;
            }

        } catch (Exception e) {
            log.error("로그인 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(resultMap, status);
    }

    // 로그아웃
    @GetMapping("/logout/{userId}")
    public ResponseEntity<Map<String, Object>> logout(@PathVariable String userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = null;
        try {
            service.deleteRefreshToken(userId);
            resultMap.put("message", SUCCESS);
            status = HttpStatus.ACCEPTED;
        } catch (Exception e) {
            log.error("로그아웃 실패 : {}", e.getMessage());
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(resultMap, status);
    }

    // 회원 가입
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto dto) {
        User duplicated = null;
        try {
            duplicated = service.findUserByUserId(dto.getUserId());
        } catch (Exception e) {
            log.error("{}", e);
        }
        if (duplicated != null) {
            return new ResponseEntity<>("duplicated user id", HttpStatus.BAD_REQUEST);
        }
        int value = service.join(dto);
        if (value != 0) {
            return new ResponseEntity<>("join success", HttpStatus.OK);
        }
        return new ResponseEntity<>("join fail", HttpStatus.BAD_REQUEST);
    }

    // 회원 정보 수정
    @PutMapping("")
    public ResponseEntity<String> modify(HttpSession session, @RequestBody UserModifyRequestDto dto) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>("session is null", HttpStatus.NO_CONTENT);
        }
        dto.setUserId(user.getUserId());
        int modify = service.modify(dto);

        if (modify != 0) {
            return new ResponseEntity<>("modify success", HttpStatus.OK);
        }
        return new ResponseEntity<>("modify fail", HttpStatus.BAD_REQUEST);
    }

    // 회원 탈퇴
    @DeleteMapping("")
    public ResponseEntity<String> delete(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new ResponseEntity<>("session is null", HttpStatus.NO_CONTENT);
        }
        int value = service.delete(user.getUserId());
        if (value == 0) {
            return new ResponseEntity<>("delete fail", HttpStatus.NO_CONTENT);
        }
        session.invalidate();
        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

    @GetMapping("/info/{userId}")
    public ResponseEntity<Map<String, Object>> getInfo(@PathVariable("userId") String userId, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        if (jwtService.checkToken(request.getHeader("access-token"))) {
            log.info("토큰 사용 가능");
            try {
                User user = service.findUserByUserId(userId);
                resultMap.put("userInfo", user);
                resultMap.put("message", SUCCESS);
                status = HttpStatus.ACCEPTED;
            } catch (Exception e) {
                log.error("정보 조회 실패 : {}", e);
                resultMap.put("message", e.getMessage());
                status = HttpStatus.INTERNAL_SERVER_ERROR;
            }
        } else {
            log.error("사용 불가능 토큰");
            resultMap.put("message", FAIL);
            status = HttpStatus.UNAUTHORIZED;
        }

        return new ResponseEntity<>(resultMap, status);
    }


}
