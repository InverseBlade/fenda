package com.zzw.fenda.dao;

import com.zzw.fenda.dto.UserListDTO;
import com.zzw.fenda.dto.UserListFilter;
import com.zzw.fenda.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    void insertAndGetUId(User user) throws Exception;

    void deleteByUId(@Param("uid") Integer uid) throws Exception;

    User selectByUId(@Param("uid") Integer uid) throws Exception;

    void updateByUId(User user) throws Exception;

    User selectByOpenId(@Param("openId") String openId) throws Exception;

    List<UserListDTO> listUserByFilter(@Param("filter") UserListFilter filter,
                                       @Param("offset") Integer offset,
                                       @Param("limit") Integer limit) throws Exception;

    List<UserListDTO> listUnListenedBloggerByViewer(@Param("filter") UserListFilter filter,
                                                    @Param("viewer") Integer viewer,
                                                    @Param("offset") Integer offset,
                                                    @Param("limit") Integer limit) throws Exception;

}
