package com.zzw.fenda.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Map<String, String> index() {
        HashMap<String, String> map = new HashMap<>();
        map.put("errCode", "0");
        map.put("errMsg", "success");
        return map;
    }

}
