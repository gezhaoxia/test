package com.zuoshao.vote.mapper;

import com.zuoshao.vote.bean.Fight;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zuoshao
 * @date 2019/6/19 - 19:13
 */
public interface Fightmapper extends Mapper<Fight> {
    public Fight selectnewfight(Integer sessionid);
}
