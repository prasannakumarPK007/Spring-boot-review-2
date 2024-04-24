package com.eventmanagement.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.login.model.Signup;
import com.eventmanagement.login.service.SignService;

@RestController
@RequestMapping("/sign")
public class SignController {

    @Autowired
    private SignService signService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Signup signup) {
        Signup sign = signService.getUser(signup.getEmailId());
        if (sign == null) {
            signService.signup(signup);
            signService.signup(signup);
            return new ResponseEntity<String>("Signed up successfully", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("EmailId already exists, please use another EmailId", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/login")
    public String login(@RequestParam String emailId, @RequestParam String password) {
        Signup log = signService.loginCheck(emailId, password);
        if (log == null) {
            return "Invalid Email Id or password";
        }
        return "Login Successful";
    }
}
