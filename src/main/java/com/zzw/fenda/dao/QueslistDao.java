package com.zzw.fenda.dao;

import com.zzw.fenda.dto.AskListDTO;
import com.zzw.fenda.dto.AskListFilter;
import com.zzw.fenda.po.Queslist;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QueslistDao {

    void insertAndGetId(@Param("quesList") Queslist queslist) throws Exception;

    void updateReplyById(@Param("quesList") Queslist queslist) throws Exception;

    List<AskListDTO> listQuesByFilter(@Param("filter") AskListFilter filter,
                                      @Param("limit") Integer limit,
                                      @Param("offset") Integer offset) throws Exception;

    Queslist selectById(@Param("id") Integer id) throws Exception;

}
