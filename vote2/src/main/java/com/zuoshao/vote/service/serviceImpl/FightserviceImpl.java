package com.zuoshao.vote.service.serviceImpl;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Fight;
import com.zuoshao.vote.bean.Fight_condidate;
import com.zuoshao.vote.mapper.Fightcondidatemapper;
import com.zuoshao.vote.mapper.Fightmapper;
import com.zuoshao.vote.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/19 - 19:17
 */
@Service
public class FightserviceImpl implements FightService {
    @Autowired
    Fightmapper fightmapper;
    @Autowired
    Fightcondidatemapper fightcondidatemapper;

    @Override
    public List<Fight> selectfightall(Fight fight) {
        List<Fight> fightList = fightmapper.select(fight);
        return fightList;
    }

    @Override
    public Integer addfightcondidate(Fight_condidate fight_condidate) {
        int insert = fightcondidatemapper.insert(fight_condidate);
        return insert;
    }

    @Override
    public Integer addfight(Fight fight) {
        int insert = fightmapper.insert(fight);
        return insert;
    }

    @Override
    public Fight selectnewfight(Integer sessionid) {
        Fight fight = fightmapper.selectnewfight(sessionid);
        return fight;
    }

    @Override
    public Integer deletefight(Fight fight) {
        int delete = fightmapper.delete(fight);
        return delete;
    }

    @Override
    public Integer deletefightcondidate(Fight_condidate fight_condidate) {
        int delete = fightcondidatemapper.delete(fight_condidate);
        return delete;
    }

    @Override
    public List<Fight_condidate> selectfightcondidate(Fight_condidate fight_condidate) {
        List<Fight_condidate> select = fightcondidatemapper.select(fight_condidate);
        return select;
    }

    @Override
    public List<Fight_condidate> sessionnogoingfight(Fight_condidate fandc) {
        List<Fight_condidate> select = fightcondidatemapper.select(fandc);
        return select;
    }

    @Override
    public Fight fightnogoning(Fight fight) {
        fight.setState(1);
        Fight fight1 = fightmapper.selectOne(fight);
        return fight1;
    }

    @Override
    public Fight fightnofightid(Fight fight) {
        Fight fight1 = fightmapper.selectOne(fight);
        return fight1;
    }

    @Override
    public Integer updatefight(Fight fight) {
        Integer i = fightmapper.updateByPrimaryKey(fight);
        return i;
    }
}
