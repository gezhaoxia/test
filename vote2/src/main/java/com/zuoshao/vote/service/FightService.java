package com.zuoshao.vote.service;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Fight;
import com.zuoshao.vote.bean.Fight_condidate;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/19 - 19:14
 */
public interface FightService {
    //根据fight表中的场次id查询这场比赛所有的对战
    public List<Fight> selectfightall(Fight fight);
    //为这个对战添加一个选手
    public Integer addfightcondidate(Fight_condidate fight_condidate);
    //添加一场对战(单一的不带任何东西)
    public Integer addfight(Fight fight);
    //通过场次id返回最新加入的对战
    public Fight selectnewfight(Integer sessionid);
    //删除对战表中的该场对战
    public Integer deletefight(Fight fight);
    //删除对战人员表中的该场对战信息（2）
    public Integer deletefightcondidate(Fight_condidate fight_condidate);
    //根据这个人的id查询他参加的所有对战
    public List<Fight_condidate> selectfightcondidate(Fight_condidate fight_condidate);
    //返回当场对战中正在进行中的对战的人员
    public List<Fight_condidate> sessionnogoingfight(Fight_condidate fandc);
    //根据比赛场次id和正在进行中这个状态返回一场对战
    public Fight fightnogoning(Fight fight);
    //根据比赛场次id返回一场对战
    public Fight fightnofightid(Fight fight);
    //更改一场对战
    public Integer updatefight(Fight fight);
}
