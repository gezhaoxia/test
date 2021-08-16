package com.zuoshao.vote.service.serviceImpl;

import com.zuoshao.vote.bean.Votenumber;
import com.zuoshao.vote.mapper.Votemapper;
import com.zuoshao.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/24 - 11:29
 */
@Service
public class VoteserviceImpl implements VoteService {
    @Autowired
    Votemapper votemappers;

    @Override
    public Integer addvote(Votenumber votenumber){
        int insert = votemappers.insert(votenumber);
        return insert;
    }

    @Override
    public Votenumber selectvoteonly(Votenumber votenumber) {
        votenumber.setCondidateid(null);
        Votenumber votenumber1 = votemappers.selectOne(votenumber);
        return votenumber1;
    }

    @Override
    public List<Votenumber> censusstate(Votenumber votenumber) {
        List<Votenumber> select = votemappers.select(votenumber);
        return select;
    }
}
