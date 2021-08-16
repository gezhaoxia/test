package com.zuoshao.vote.controller;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Fight;
import com.zuoshao.vote.bean.Session;
import com.zuoshao.vote.bean.Votenumber;
import com.zuoshao.vote.service.CondidateService;
import com.zuoshao.vote.service.VoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/23 - 16:49
 */
@Controller
public class VoteController {

    @Autowired
    VoteService voteService;
    @Autowired
    CondidateService condidateservice;


    @RequestMapping(value = "/vote")
    public String forvote()
    {
        return "vote";
    }
    @RequestMapping(value = "/votetables")
    public String forvotetables()
    {
        return "votetables";
    }

    @RequestMapping(value = "/changci")
    public String forchangci()
    {
        return "changci";
    }

    @RequestMapping(value = "/content")
    public String forcontent()
    {
        return "content";
    }

    @RequestMapping(value = "/vs")
    public String forvs(){

        return "Vs";
    }
    @GetMapping("forvs")
    public String forvs(@Param("fight")Integer fightid, HttpSession session){
        List<Condidate> selectfightcondidate = condidateservice.selectfightcondidate(fightid);
        session.setAttribute("fightid",fightid);
        session.setAttribute("condidate",selectfightcondidate);
        return "Vs";
    }


    @PostMapping(value = "addvote")
    @ResponseBody
    public Integer addvote(Votenumber votenumber){
        Votenumber votenumber1 = new Votenumber();
        votenumber1.setCondidateid(votenumber.getCondidateid());
        votenumber1.setFightid(votenumber.getFightid());
        votenumber1.setUserid(votenumber.getUserid());

        if (1==1){
            Votenumber selectvoteonly = voteService.selectvoteonly(votenumber);
            if (selectvoteonly != null){
                return 0;
            } else {

                Integer addvote = voteService.addvote(votenumber1);
                return addvote;
            }
        }
        return 0;
    }

    @GetMapping(value = "censusvote")
    @ResponseBody
    public List censusvote(@Param("fightid")Integer fightid){
        List<Condidate> selectfightcondidate = condidateservice.selectfightcondidate(fightid);

        Votenumber votenumber = new Votenumber();
        votenumber.setFightid(fightid);

        List<Integer> list =new ArrayList<Integer>();
        for (Condidate condidate:selectfightcondidate) {
            Integer id = condidate.getId();
            votenumber.setCondidateid(id);
            List<Votenumber> censusstate = voteService.censusstate(votenumber);
            list.add(censusstate.size());
        }
        return  list;
    }



}
