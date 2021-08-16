package com.zuoshao.vote.controller;

import com.zuoshao.vote.bean.Session;
import com.zuoshao.vote.service.SessionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zuoshao
 * @date 2019/6/15 - 17:16
 */
@Controller
public class SessionController {
    @Autowired
    SessionService sessionService;

    @RequestMapping(value = "/sessionall")
    @ResponseBody
    public List<Session> sessions()
    {
        List<Session> sessionall = sessionService.sessionall();
        return sessionall;
    }

    @RequestMapping(value = "/deletesessionone",method = RequestMethod.GET)
    @ResponseBody
    public Integer deletesessionone(@Param("id")Integer id){
        if(id==null){
            return 0;
        }
        Session session = new Session();
        session.setId(id);
        int i = sessionService.deletsessionone(session);
        return i;
    }

    @RequestMapping(value = "/addsession",method = RequestMethod.POST)
    @ResponseBody
    public Integer addsession(Session session){
        Integer addsession = sessionService.addsession(session);
        return addsession;
    }

    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "filename") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://IDEAworkspace//vote//src//main//resources//static//image//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        //判断父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/image/" + fileName;
        model.addAttribute("filename", filename);
        return "condidateall";
    }

    //返回所有在进行中的比赛
    @GetMapping(value = "sessionallnogoing")
    public String sessionallnogoing(Model model){
        Session session = new Session();
        List<Session> sessionlist = sessionService.sessionallongoing(session);
        model.addAttribute("sessions",sessionlist);
        model.addAttribute("state","进行中");
        return "changci";
    }

    @RequestMapping(value = "sesionnogoing")
    @ResponseBody
    public List<Session> sessionallnogoings(){
        Session session = new Session();
        List<Session> sessionlist = sessionService.sessionallongoing(session);
        System.out.println(session);
        return sessionlist;
    }
}
