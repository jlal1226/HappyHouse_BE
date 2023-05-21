package com.ssafy.controller;

import com.ssafy.domain.user.JoinDto;
import com.ssafy.domain.user.LoginDto;
import com.ssafy.domain.user.User;
import com.ssafy.domain.user.UserModifyRequestDto;
import com.ssafy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    // 로그인
    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto, HttpSession session) {
        User user = service.loginProcess(dto);
        if (user != null) {
            session.setAttribute("user", user);
            return new ResponseEntity<>("login success", HttpStatus.OK);
        }
        return new ResponseEntity<>("login fail", HttpStatus.NOT_FOUND);
    }

    // 로그아웃
    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>("logout success", HttpStatus.OK);
    }

    // 회원 가입
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto dto) {
        int duplicated = service.findUserByUserId(dto.getUserId());
        if (duplicated != 0) {
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

}
