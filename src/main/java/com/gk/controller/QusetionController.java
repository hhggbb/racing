package com.gk.controller;

import com.gk.action.SystemAction;
import com.gk.model.*;
import com.gk.service.*;
import com.gk.utilsEntity.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-12 9:11
 */
@RestController
@RequestMapping("/question")
public class QusetionController {
    @Autowired
    private JudgeService judgeService;
    @Autowired
    private ShortAnswerService shortAnswerService;
    @Autowired
    private SingleChoiceService singleChoiceService;
    @Autowired
    private MultipleChoiceService multipleChoiceService;
    @Autowired
    private RedSongService redSongService;
    @Autowired
    private QuicklyAnswerService quicklyAnswerService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private SystemAction systemAction;
    @Autowired
    private MatchRuleService matchRuleService;
    @Autowired
    private TeamScoreRecordService teamScoreRecordService;

    //遍历器
    private Iterator<QuestionVo> questionVoIterator;

    //存放当前题目的id
    private Integer quicklyAnswerId;
    //比赛规则
    private String ruleType;

    /**
     * 把题目放进遍历器，所有题型都调用此方法
     *
     * @param type 题目类型
     * @return
     */
    @RequestMapping("/putQuestion")
    public boolean putQuestion(@RequestParam String type) {
        try {
            //先清空原来的数据
            questionVoIterator=null;
            List<QuestionVo> questionVoList = systemAction.putQuestion(type);
            questionVoIterator = questionVoList.iterator();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //获取单条题目，所有题型都调用此方法
    @RequestMapping("/getOneQuestion")
    public QuestionVo getOneQuestion() {
        if (questionVoIterator.hasNext()) {
            QuestionVo next = questionVoIterator.next();
            //如果是抢答题
            quicklyAnswerId=next.getId();
            return next;
        }
        QuestionVo questionVo = new QuestionVo();
        questionVo.setTitle("该题型题目读取完毕...");
        questionVo.setScore(0);
        return questionVo;
    }

    //获取所有红歌
    @RequestMapping("/getRedSongs")
    public List<RedSong> getRedSongs() {
        try {
            List<RedSong> redSongList = redSongService.list();
            if (redSongList != null) {
                return redSongList;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //抢答者页面显示题目
    @RequestMapping("/getQuicklyAnswer")
    public QuicklyAnswer getQuicklyAnswer() {
        try {
            if (quicklyAnswerId != null) {
                QuicklyAnswer quicklyAnswer = quicklyAnswerService.getById(quicklyAnswerId);
                return quicklyAnswer;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 必答题计分
     *
     * @param titleId 题号
     * @param answer  答案（对或错）
     * @param score   题目的分数
     * @return
     */
    @PostMapping("/count")
    public boolean count(@RequestParam Integer titleId, @RequestParam String answer, @RequestParam Integer score,@RequestParam String type) {
        try {
            if (titleId != null && answer != null && score != null&&type!=null) {
                //插入答题数据记录
                boolean b = systemAction.insertRecord(titleId, answer, score, type);
                //记录分数
                boolean b1 = teamService.countScore(titleId, answer, score);
                return b&&b1;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取比赛规则
     * @return
     */
    @RequestMapping("/getRules")
    public List<MatchRule> getRules(){
        try {
            List<MatchRule> list = matchRuleService.list();
            if(!list.isEmpty()){
                return list;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 便于获取题型规则
     * @return
     */
    @RequestMapping("/putOneRule")
    public void putOneRule(@RequestParam String type){
        ruleType=type;
    }

    /**
     * 获取单条题型的比赛规则
     * @return
     */
    @RequestMapping("/getOneRule")
    public MatchRule getOneRule(){
        try {
            MatchRule oneRule = matchRuleService.getOneRule(ruleType);
            if(oneRule!=null){
                return oneRule;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
