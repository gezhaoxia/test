package com.zuoshao.vote.controller;

import com.zuoshao.vote.bean.Condidate;
import com.zuoshao.vote.bean.Fight;
import com.zuoshao.vote.bean.Fight_condidate;
import com.zuoshao.vote.mapper.Fightmapper;
import com.zuoshao.vote.service.CondidateService;
import com.zuoshao.vote.service.FightService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zuoshao
 * @date 2019/6/19 - 19:19
 */
@Controller
public class FightController {
    @Autowired
    FightService fightservice;
    @Autowired
    CondidateService condidateservice;

    @RequestMapping(value = "selectfightall")
    @ResponseBody
    public List<Fight> selectfightall(@Param("id")Integer id){
        Fight fight = new Fight();
        fight.setSessionid(id);
        List<Fight> selectfightall = fightservice.selectfightall(fight);
        return selectfightall;
    }

    @RequestMapping(value = "fight")
    public String fighthtml(){
        return "fight";
    }

    @GetMapping(value = "addfightcondidate")
    @ResponseBody
    public Integer addfightcondidate(@Param("fightid")Integer fightid,@Param("condidateid")Integer condidateid){
        Fight_condidate fight_condidate = new Fight_condidate();
        fight_condidate.setFightid(fightid);
        fight_condidate.setCondidateid(condidateid);

        Integer addfightcondidate = fightservice.addfightcondidate(fight_condidate);

        return addfightcondidate;
    }

    @PostMapping(value = "addfight")
    @ResponseBody
    public Fight addfight(Fight fight){

        Integer sessionid = fight.getSessionid();
        //添加对战
        Integer addfight = fightservice.addfight(fight);
        //返回最新添加的对战
        Fight selectnewfight = fightservice.selectnewfight(sessionid);
        return selectnewfight;
    }

    @GetMapping(value = "deletefight")
    @ResponseBody
    public Integer deletefight(@Param("fightid")Integer fightid){
        Fight fight = new Fight();
        fight.setId(fightid);
        Integer deletefight = fightservice.deletefight(fight);
        Fight_condidate fight_condidate = new Fight_condidate();
        fight_condidate.setFightid(fightid);
        Integer deletefightcondidate = fightservice.deletefightcondidate(fight_condidate);
        return deletefight+deletefightcondidate;
    }

    @GetMapping(value = "deletfightcondidate")
    @ResponseBody
    public Integer deletfightcondidate(@Param("fightid")Integer fightid,@Param("condidateid")Integer condidateid){
        Fight_condidate fight_condidate = new Fight_condidate();
        fight_condidate.setFightid(fightid);
        fight_condidate.setCondidateid(condidateid);
        Integer deletefightcondidate = fightservice.deletefightcondidate(fight_condidate);
        return deletefightcondidate;
    }

    @GetMapping(value = "sessionnogoingfight")
    public String sessionnogoingfight(@RequestParam("sessionid")Integer sessionid, HttpServletRequest request, Model model){
        Fight fight = new Fight();
        fight.setSessionid(sessionid);
        Fight fightnogoning = fightservice.fightnogoning(fight);
        if (fightnogoning!=null){

        Fight_condidate fight_condidate = new Fight_condidate();
        fight_condidate.setFightid(fightnogoning.getId());

        List<Fight_condidate> sessionnogoingfight = fightservice.sessionnogoingfight(fight_condidate);

            List<Condidate> condidates = new ArrayList<Condidate>();
            for (Fight_condidate date:sessionnogoingfight) {
                Condidate condidate = new Condidate();
                condidate.setId( date.getCondidateid());
                condidates.add(condidateservice.selectonecondidate(condidate));
            }
            model.addAttribute("condidates",condidates);
            model.addAttribute("fight",fightnogoning);
            return "content";
        }else {
//            request.setAttribute("messsage","当前比赛没有对战在进行中");
            return "redirect:sessionallnogoing";
        }

    }

    @GetMapping(value = "fightnogoingone")
    @ResponseBody
    public Fight fightnogoingone(@Param("sessionid")Integer sessionid){
        Fight fight = new Fight();
        fight.setSessionid(sessionid);

        Fight fightnogoning = fightservice.fightnogoning(fight);

        if (fightnogoning!=null){
            return fightnogoning;
        }else {
            return null;
        }
    }

    @GetMapping(value = "fightstateno")
    @ResponseBody
    public Integer fightstateno(@Param("fightid")Integer fightid){
        Fight fight = new Fight();
        fight.setId(fightid);
        Fight fight1 = fightservice.fightnofightid(fight);
        fight1.setState(1);
        Integer updatefight = fightservice.updatefight(fight1);
        return updatefight;
    }


    @GetMapping(value = "fightstateoff")
    @ResponseBody
    public Integer fightstateoff(@Param("fightid")Integer fightid){
        Fight fight = new Fight();
        fight.setId(fightid);
        Fight fight1 = fightservice.fightnofightid(fight);
        fight1.setState(0);
        Integer updatefight = fightservice.updatefight(fight1);
        return updatefight;
    }
}
