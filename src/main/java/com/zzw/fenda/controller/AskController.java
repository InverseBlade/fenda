package com.zzw.fenda.controller;

import com.zzw.fenda.dao.QueslistDao;
import com.zzw.fenda.dto.AskListDTO;
import com.zzw.fenda.dto.AskListFilter;
import com.zzw.fenda.po.Queslist;
import com.zzw.fenda.util.JsonR;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

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
        try {
            Integer giverID = (Integer) request.getAttribute("uid");
            Queslist queslist = new Queslist();

            queslist.setGiverID(giverID)
                    .setSolverID(solverID)
                    .setQuesInfo(quesInfo);

            queslistDao.insertAndGetId(queslist);
            return JsonR.createSuccess(queslist.getQuesID());
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public JsonR reply(Integer quesID,
                       String answer,
                       String audioUrl,
                       HttpServletRequest request) {
        try {
            Integer solverID = (Integer) request.getAttribute("uid");
            Queslist queslist;

            if ((queslist = queslistDao.selectById(quesID)) == null) {
                throw new Exception("问题不存在");
            }
            if (!queslist.getSolverID().equals(solverID)) {
                throw new Exception("你不是该问题的回答者");
            }
            queslist.setAnswer(answer)
                    .setAudioUrl(audioUrl)
                    .setSolveDate(new Timestamp(System.currentTimeMillis()));

            queslistDao.updateReplyById(queslist);
            return JsonR.createSuccess(queslist.getQuesID());
        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping("/list")
    public JsonR list(AskListFilter askListFilter,
                      Integer order,
                      Integer page,
                      Integer limit) {
        try {
            page = page == null ? 1 : page;
            limit = limit == null ? 10 : limit;
            int offset = (page - 1) * limit;

            List<AskListDTO> askListDTOList;
            askListDTOList = queslistDao.listQuesByFilter(askListFilter, limit, offset);

            return JsonR.createSuccess(askListDTOList);

        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }

    @RequestMapping("/get")
    public JsonR get(Integer quesID) {
        try {
            Queslist queslist;

            if ((queslist = queslistDao.selectById(quesID)) == null) {
                throw new Exception("问题不存在");
            }
            return JsonR.createSuccess(queslist);

        } catch (Exception e) {
            return JsonR.createFail(e.getMessage());
        }
    }


}























