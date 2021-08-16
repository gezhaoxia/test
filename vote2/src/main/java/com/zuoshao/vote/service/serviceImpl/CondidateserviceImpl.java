package com.zuoshao.vote.service.serviceImpl;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Session_condidate;
import com.zuoshao.vote.mapper.Condidatemapper;
import com.zuoshao.vote.mapper.SandCmapper;
import com.zuoshao.vote.service.CondidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/16 - 10:10
 */
@Service
public class CondidateserviceImpl implements CondidateService {

    @Autowired
    Condidatemapper condidatemapper;
    @Autowired
    SandCmapper sandcmapper;
    @Override
    public List<Condidate> selectssidallcondidate(Integer sessionid) {
        List<Condidate> list = condidatemapper.selectssidallcondidate(sessionid);
        return list;
    }

    @Override
    public Condidate selectonecondidate(Condidate condidate) {
        Condidate condidate1 = condidatemapper.selectOne(condidate);
        return condidate1;
    }

    @Override
    public List<Condidate> condidateall() {
        List<Condidate> condidates = condidatemapper.selectAll();
        return condidates;
    }

    @Override
    public Integer addonecondidate(Session_condidate sandc) {
        Integer insert = sandcmapper.insert(sandc);
        return insert;
    }

    @Override
    public Integer deleteonecondidate(Session_condidate sandc) {
        Integer delete = sandcmapper.delete(sandc);
        return delete;
    }

    @Override
    public Integer addcondidate(Condidate condidate) {
        Integer insert = condidatemapper.insert(condidate);
        return insert;
    }

    @Override
    public Integer deletecondidate(Condidate condidate) {
        Integer delete = condidatemapper.delete(condidate);
        return delete;
    }

//    @Override
//    public Integer deletecondidatesession(Condidate condidate) {
//        return null;
//    }

    @Override
    public List<Session_condidate> sandcall() {
        List<Session_condidate> session_condidates = sandcmapper.selectAll();
        return session_condidates;
    }

    @Override
    public List<Condidate> selectfightcondidate(Integer fightid) {
        ArrayList list = condidatemapper.selectfightcondidate(fightid);
        return list;
    }

}
