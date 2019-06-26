package com.zzw.fenda.controller;

import com.zzw.fenda.po.User;
import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public JsonR modify(User user) {
        return null;
    }

    @RequestMapping("/me")
    public JsonR me() {
        return JsonR.createSuccess(new User());
    }

    @RequestMapping("/get")
    public JsonR get(Integer uid) {
        return null;
    }

}
