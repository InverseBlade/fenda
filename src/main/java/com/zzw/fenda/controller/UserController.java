package com.zzw.fenda.controller;

import com.zzw.fenda.dao.UserDao;
import com.zzw.fenda.dto.UserBasicDTO;
import com.zzw.fenda.dto.UserListDTO;
import com.zzw.fenda.dto.UserListFilter;
import com.zzw.fenda.po.User;
import com.zzw.fenda.util.JsonR;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserDao userDao;

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public JsonR modify(User user,
                        HttpServletRequest request) {
        try {
            Integer uid = (Integer) request.getAttribute("uid");
            user.setUid(uid);
            userDao.updateByUId(user);
            return JsonR.createSuccess();
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping("/me")
    public JsonR me(HttpServletRequest request) {
        try {
            User user;
            Integer uid = (Integer) request.getAttribute("uid");
            if ((user = userDao.selectByUId(uid)) == null) {
                throw new Exception("用户不存在");
            }
            return JsonR.createSuccess(user);
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping("/get")
    public JsonR get(Integer uid) {
        try {
            UserBasicDTO userBasicDTO = new UserBasicDTO();
            User user;
            if ((user = userDao.selectByUId(uid)) == null) {
                throw new Exception("用户不存在");
            }
            BeanUtils.copyProperties(user, userBasicDTO);
            return JsonR.createSuccess(userBasicDTO);
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping("/list")
    public JsonR list(UserListFilter userListFilter,
                      Integer page,
                      Integer limit,
                      HttpServletRequest request) {
        try {
            page = page == null ? 1 : page;
            limit = limit == null ? 7 : limit;
            int offset = (page - 1) * limit;

            List<UserListDTO> userListDTOList;
//            userListDTOList = userDao.listUserByFilter(userListFilter, offset, limit);
            Integer uid = (Integer) request.getAttribute("uid");

            userListDTOList = userDao.listUnListenedBloggerByViewer(userListFilter, uid, offset, limit);

            return JsonR.createSuccess(userListDTOList);

        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

}



















