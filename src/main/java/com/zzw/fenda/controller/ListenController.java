package com.zzw.fenda.controller;

import com.zzw.fenda.dao.ConcernDao;
import com.zzw.fenda.dto.AskListDTO;
import com.zzw.fenda.dto.UserListDTO;
import com.zzw.fenda.po.Concern;
import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/listen")
public class ListenController {

    @Resource
    private ConcernDao concernDao;

    public JsonR get(Integer uid,
                     HttpServletRequest request) {
        try {
            Integer viewer = (Integer) request.getAttribute("uid");
            Concern concern;
            if ((concern = concernDao.selectByViewerAndBlogger(viewer, uid)) == null) {
                return JsonR.createFail("未收听");
            } else {
                return JsonR.createSuccess(concern.getConcernDate());
            }
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public JsonR create(Integer uid,
                        HttpServletRequest request) {
        try {
            Integer viewer = (Integer) request.getAttribute("uid");
            Concern concern = new Concern();

            concern.setViewer(viewer).setBlogger(uid);
            concernDao.insert(concern);
            return JsonR.createSuccess();
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public JsonR del(Integer uid,
                     HttpServletRequest request) {
        try {
            Integer viewer = (Integer) request.getAttribute("uid");
            concernDao.deleteByViewerAndBlogger(viewer, uid);
            return JsonR.createSuccess();
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping("/list")
    public JsonR list(Integer page,
                      Integer limit,
                      HttpServletRequest request) {
        try {
            page = page == null ? 1 : page;
            limit = limit == null ? 7 : limit;
            int offset = (page - 1) * limit;

            List<UserListDTO> userListDTOS;
            Integer viewer = (Integer) request.getAttribute("uid");
            userListDTOS = concernDao.listUserByViewer(viewer, limit, offset);

            return JsonR.createSuccess(userListDTOS);

        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }

    }

    @RequestMapping("/queslist")
    public JsonR quesList(Integer page,
                          Integer limit,
                          HttpServletRequest request) {
        try {
            page = page == null ? 1 : page;
            limit = limit == null ? 7 : limit;
            int offset = (page - 1) * limit;

            Integer viewer = (Integer) request.getAttribute("uid");
            List<AskListDTO> askListDTOList = concernDao.listQuesByViewer(viewer, limit, offset);

            return JsonR.createSuccess(askListDTOList);

        } catch (Exception e) {
            return JsonR.createSuccess(e.getMessage());
        }
    }

}

























