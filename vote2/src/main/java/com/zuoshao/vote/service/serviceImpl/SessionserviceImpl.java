package com.zuoshao.vote.service.serviceImpl;

import com.zuoshao.vote.bean.Session;
import com.zuoshao.vote.mapper.Sessionmapper;
import com.zuoshao.vote.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/15 - 17:10
 */
@Service
public class SessionserviceImpl implements SessionService {
    @Autowired
    Sessionmapper sessionmapper;

    @Override
    public List<Session> sessionall() {
        List<Session> sessions = sessionmapper.selectAll();
        return sessions;
    }

    @Override
    public Integer deletsessionone(Session session) {
        Integer delete = sessionmapper.delete(session);
        return delete;
    }

    @Override
    public Integer addsession(Session session) {
        Integer insert = sessionmapper.insert(session);
        return insert;
    }

    @Override
    public List<Session> sessionallongoing(Session session) {
        session.setState(1);
        List<Session> select = sessionmapper.select(session);
        return select;
    }
}
