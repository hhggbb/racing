package com.gk.controller;

import com.gk.utilsEntity.Message;
import com.gk.model.TeamQuicklyAnswer;
import com.gk.service.TeamQuicklyAnswerService;
import com.gk.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-21 17:01
 */
@RestController
@RequestMapping("/answer2")
public class AnswerController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamQuicklyAnswerService teamQuicklyAnswerService;

    //参赛者团队名字列表
    private List<String> teamNameList=new ArrayList<>();

    //当前抢答到题目者名字
    private String currentName;
    //标记开始答题
    private boolean isStartAnswer=false;
    //当前题目犯规的选手
    private String foulName;

    //插入抢答题参赛团队数据
    @PostMapping("/insertTeam")
    public boolean insertTeam(@RequestParam String name){
        try{
            Integer integer = teamQuicklyAnswerService.insertTeam(name);
            if(integer!=null){
                //储存成功，往团队列表添加数据
                teamNameList.add(name);
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //参赛者页面main.html获取回答者的名字
    @RequestMapping("/getAnswerName")
    public ResponseEntity<Message> getAnswerName(){
        String answerName = teamQuicklyAnswerService.getAnswerName();
        if(answerName!=null){
            Message message=new Message();
            message.setMsg(answerName);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        return null;
    }

    //获取参赛团队列表
    @RequestMapping("/getTeamList")
    public List<String> getTeamList(){
        if(teamNameList.isEmpty()){
            return null;
        }else {
            return teamNameList;
        }
    }

    //从数据库获取所有参赛队伍 todo 没有用到此方法
    @RequestMapping("/getTeam")
    public List<String> getTeam(){
        List<TeamQuicklyAnswer> teamQuicklyAnswerList = teamQuicklyAnswerService.list();
        List<String> stringList=new ArrayList<>();
        for (TeamQuicklyAnswer teamQuicklyAnswer :teamQuicklyAnswerList) {
            stringList.add(teamQuicklyAnswer.getName());
        }
        return stringList;
    }


    //抢答者抢答按钮调用的接口
    @PostMapping("/answer")
    public String answer(@RequestParam String name){
        //返回消息
        String message;
        //判断是否犯规 答题是否开始
        if(!isStartAnswer){
            //标记当前题目犯规的选手
            foulName=name;
            message="答题还没开始，犯规~";
            return message;
        }
        //如果不等于，说明已经被别人获得了抢答权
        if(currentName!=null){
            message="未能抢到题目~";
            return message;
        }
        //重复点击答题按钮
        if(currentName==name){
            message="请不要重复点击~";
            return message;
        }
        //获取当前抢答者的名字
        currentName=name;
        message="抢到题目！";
        return message;
    }

    /**
     * 1.json必须是对象或者数组
     *
     * 2.不能有多余的东西，严格的json格式
     *
     * 3.id、pid、name等必须加双引号
     * @return
     * quickly_answer.html
     */
    //获取回答者的名字
    @RequestMapping("/getAnswer")
    public ResponseEntity<Message> getAnswer(){
        Message message=new Message();
        if(currentName==null){
            message.setStatus(101);
            message.setMsg("正在获取...");
        }else{
            message.setStatus(100);
            message.setMsg(currentName);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping("/clearCurrentName")
    public ResponseEntity<Message> clearCurrentName(){
        //清空当前答题者和犯规者
        currentName=null;
        foulName=null;
        Message message=new Message();
        message.setMsg("当前答题者清空完毕");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //标记开始答题
    @PostMapping("/startAnswer")
    public ResponseEntity<Message> startAnswer(){
        //如果还没开始，
        Message message=new Message();
        isStartAnswer=true;
        message.setMsg("答题开始");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //标记答题结束
    @PostMapping("/stopAnswer")
    public ResponseEntity<Message> stopAnswer(){
        //如果还没开始，
        Message message=new Message();
        //标记答题结束
        isStartAnswer=false;
        message.setMsg("当前题目答题结束");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //获取犯规者
    @RequestMapping("/getFoulName")
    public ResponseEntity<Message> getFoulName(){
        Message message=new Message();
        if(foulName!=null){
            message.setStatus(100);
            message.setMsg(foulName);
            foulName=null;
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        message.setStatus(101);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
