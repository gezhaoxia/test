package com.zuoshao.vote.service;

import com.zuoshao.vote.bean.Votenumber;
import com.zuoshao.vote.mapper.Votemapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/24 - 11:26
 */
public interface VoteService {

    public Integer addvote(Votenumber votenumber);

    //根据三个id 投票人id 对战id 选手id 判断是否是唯一的一票
    public Votenumber selectvoteonly(Votenumber votenumber);
    //根据 候选人id 和对战id 返回当前选手的票数
    public List<Votenumber> censusstate(Votenumber votenumber);
}
