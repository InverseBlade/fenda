package com.zzw.fenda.dao;

import com.zzw.fenda.dto.AskListDTO;
import com.zzw.fenda.dto.UserListDTO;
import com.zzw.fenda.po.Concern;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConcernDao {

    void insert(Concern concern) throws Exception;

    void deleteByViewerAndBlogger(@Param("viewer") Integer viewer,
                                  @Param("blogger") Integer blogger) throws Exception;

    Concern selectByViewerAndBlogger(@Param("viewer") Integer viewer,
                                     @Param("blogger") Integer blogger) throws Exception;

    List<UserListDTO> listUserByViewer(@Param("viewer") Integer viewer,
                                       @Param("limit") Integer limit,
                                       @Param("offset") Integer offset) throws Exception;

    List<AskListDTO> listQuesByViewer(@Param("viewer") Integer viewer,
                                      @Param("limit") Integer limit,
                                      @Param("offset") Integer offset) throws Exception;

}
