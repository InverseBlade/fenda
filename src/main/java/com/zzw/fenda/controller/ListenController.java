package com.zzw.fenda.controller;

import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/listen")
public class ListenController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JsonR create(Integer uid) {
        return null;
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public JsonR del(Integer uid) {
        return null;
    }

    @RequestMapping("/list")
    public JsonR list(Integer page,
                      Integer limit) {
        return null;
    }

    @RequestMapping("/queslist")
    public JsonR quesList(Integer page,
                          Integer limit) {
        return null;
    }

}
