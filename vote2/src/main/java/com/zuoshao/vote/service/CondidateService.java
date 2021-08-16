package com.zuoshao.vote.service;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Session;
import com.zuoshao.vote.bean.Session_condidate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/16 - 10:10
 */
public interface CondidateService {

    //根据场次id返回当场的参赛人员
    public List<Condidate> selectssidallcondidate(Integer sessionid);
    //根据这个人的id返回这个人
    public Condidate selectonecondidate(Condidate condidate);
    //返回所有参赛人员
    public List<Condidate> condidateall();
    //为这场比赛添加一个人员
    public Integer addonecondidate(Session_condidate sandc);
    //为这场比赛删除一个人员（1）
    public Integer deleteonecondidate(Session_condidate sandc);
    //直接在库里边添加一个人员
    public Integer addcondidate(Condidate condidate);

    //直接在库里边删除一个人员(删除关联的对战和比赛)（3）
    public Integer deletecondidate(Condidate condidate);

//    //删除一个人员及其所有有关的对战和比赛
//    public Integer deletecondidatesession(Condidate condidate);

    //返回所有参与比赛的参赛人员
    public List<Session_condidate> sandcall();
    //返回一场对战的所有参赛人员你
    public List<Condidate> selectfightcondidate(Integer fightid);
}
