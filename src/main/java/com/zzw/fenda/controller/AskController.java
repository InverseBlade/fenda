package com.zzw.fenda.controller;

import com.zzw.fenda.dao.QueslistDao;
import com.zzw.fenda.dto.AskListFilter;
import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/ask")
public class AskController {

    @Resource
    private QueslistDao queslistDao;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public JsonR publish(Integer solverID,
                         String quesInfo,
                         HttpServletRequest request) {
        return null;
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public JsonR reply(Integer quesID,
                       String answer,
                       String audioUrl,
                       HttpServletRequest request) {
        return null;
    }

    @RequestMapping("/list")
    public JsonR list(AskListFilter askListFilter,
                      Integer order,
                      Integer page,
                      Integer limit) {
        return null;
    }

    @RequestMapping("/get")
    public JsonR get(Integer quesID) {
        return null;
    }


}























