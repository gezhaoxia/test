package com.zuoshao.vote.controller;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Fight_condidate;
import com.zuoshao.vote.bean.Session_condidate;
import com.zuoshao.vote.service.CondidateService;
import com.zuoshao.vote.service.FightService;
//import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zuoshao
 * @date 2019/6/16 - 11:12
 */
@Controller
public class CondidateController {
    @Autowired
    CondidateService condidateservice;
    @Autowired
    FightService fightService;


    @RequestMapping(value = "/condidatemanage")
    public String condidatemanage(){
        return "condidate";
    }

    @RequestMapping(value = "/sessionidallcondidate")
    @ResponseBody
    public List<Condidate> sessionidallcondidate(@Param("id")Integer id)
    {
        List<Condidate> list = condidateservice.selectssidallcondidate(id);
        return list;
    }

    @RequestMapping(value = "/condidateall")
    @ResponseBody
    public List<Condidate> sessionall(){
        List<Condidate> condidateall = condidateservice.condidateall();
        return condidateall;
    }

    @RequestMapping(value = "/addonecondidate")
    @ResponseBody
    public Integer addonecondidate(@Param("sessionId")Integer sessionId,@Param("condidateId")Integer condidateId){
        Session_condidate condidate = new Session_condidate();
        condidate.setSessionId(sessionId);
        condidate.setCondidateId(condidateId);
        Integer addonecondidate = condidateservice.addonecondidate(condidate);
        return addonecondidate;
    }

    @RequestMapping(value = "/deleteonecondidate",method = RequestMethod.GET)
    @ResponseBody
    public Integer deleteonecondidate(@Param("sessionId")Integer sessionId,@Param("condidateId")Integer condidateId){
        Session_condidate session_condidate = new Session_condidate();
        session_condidate.setSessionId(sessionId);
        session_condidate.setCondidateId(condidateId);
        Integer deleteonecondidate = condidateservice.deleteonecondidate(session_condidate);
        return deleteonecondidate;
    }

    @RequestMapping(value = "/addcondidate")
    @ResponseBody
    public Integer addcondidate(Condidate condidate){
        Integer addcondidate = condidateservice.addcondidate(condidate);
        return addcondidate;
    }

    @RequestMapping(value = "/deletecondidate")
    @ResponseBody
    public Integer deletecondidate(@Param("id")Integer id,HttpServletRequest request){
        //删除所有比赛中的这个人
        Session_condidate session_condidate = new Session_condidate();
        session_condidate.setCondidateId(id);
        Integer deleteonecondidate = condidateservice.deleteonecondidate(session_condidate);

        //删除这个人所在参加的所有对战
        //开启批量处理，关闭自动提交
//        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        Fight_condidate fight_condidate1 = new Fight_condidate();
        fight_condidate1.setCondidateid(id);
        List<Fight_condidate> selectfightcondidate = fightService.selectfightcondidate(fight_condidate1);


        //执行批量删除该人员参加的对战
        for (Fight_condidate fc:selectfightcondidate) {
            Integer deletefightcondidate = fightService.deletefightcondidate(fc);
        }
        //提交 清除缓存
//        sqlSession.commit();
//        sqlSession.clearCache();

        //在候选人人员表中删除这个人
        Condidate condidate = new Condidate();
        condidate.setId(id);
        Integer in = condidateservice.deletecondidate(condidate);
        return in;
    }

    @RequestMapping(value = "/selectfightcondidate")
    @ResponseBody
    public List<Condidate> selectfightcondidate(@Param("id")Integer id){
        List<Condidate> list = condidateservice.selectfightcondidate(id);
        return list;
    }
}
