package com.zuoshao.vote.service;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Fight_condidate;
import com.zuoshao.vote.bean.Session;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/15 - 17:08
 */
public interface SessionService {
    public List<Session> sessionall();
    //删除一场比赛
    public Integer deletsessionone(Session session);
    //增加一场比赛
    public Integer addsession(Session session);
    //返回所有正在进行中的比赛state=1
    public List<Session> sessionallongoing(Session session);


}
