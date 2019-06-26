package com.zzw.fenda.controller;

import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public JsonR login(String code, HttpServletRequest request) {
        return null;
    }

}
