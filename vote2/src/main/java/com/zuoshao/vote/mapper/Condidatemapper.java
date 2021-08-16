package com.zuoshao.vote.mapper;

import com.zuoshao.vote.bean.Condidate;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/16 - 10:09
 */
public interface Condidatemapper extends Mapper<Condidate> {

    public ArrayList selectssidallcondidate(Integer sessionid);

    public ArrayList selectfightcondidate(Integer fightid);
}
