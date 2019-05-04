package com.gk.action;

import com.gk.enums.QuestionTypeEnum;
import com.gk.enums.RightOrWrongEnum;
import com.gk.model.*;
import com.gk.service.*;
import com.gk.utilsEntity.QuestionVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统逻辑实现类
 *
 * @Author: 卖女孩的小火柴999
 * @Date: 2019-03-27 15:52
 */
@Service
public class SystemAction {
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
    private TeamScoreRecordService teamScoreRecordService;
    /**
     * 把题目放进Vo
     *
     * @param type
     * @return
     */
    public List<QuestionVo> putQuestion(String type) {
        List<QuestionVo> questionVoList = new ArrayList<>();
        //判断题
        if (QuestionTypeEnum.JUDGE.getType().equals(type)) {
            List<Judge> judgeList = judgeService.list();
            for (Judge judge : judgeList) {
                QuestionVo questionVo = new QuestionVo();
                //把judge相同的属性复制到questionVo
                BeanUtils.copyProperties(judge, questionVo);
                questionVoList.add(questionVo);
            }
        }
        //单选题
        if (QuestionTypeEnum.SINGLE_CHOICE.getType().equals(type)) {
            List<SingleChoice> singleChoiceList = singleChoiceService.list();
            for (SingleChoice singleChoice : singleChoiceList) {
                QuestionVo questionVo = new QuestionVo();
                BeanUtils.copyProperties(singleChoice, questionVo);
                questionVoList.add(questionVo);
            }
        }
        //多选题
        if (QuestionTypeEnum.MULTIPLE_CHOICE.getType().equals(type)) {
            List<MultipleChoice> multipleChoiceList = multipleChoiceService.list();
            for (MultipleChoice multipleChoice : multipleChoiceList) {
                QuestionVo questionVo = new QuestionVo();
                BeanUtils.copyProperties(multipleChoice, questionVo);
                questionVoList.add(questionVo);
            }
        }
        //简答题
        if (QuestionTypeEnum.SHORT_ANSWER.getType().equals(type)) {
            List<ShortAnswer> shortAnswerList = shortAnswerService.list();
            for (ShortAnswer shortAnswer : shortAnswerList) {
                QuestionVo questionVo = new QuestionVo();
                BeanUtils.copyProperties(shortAnswer, questionVo);
                questionVoList.add(questionVo);
            }
        }
        //抢答题
        if (QuestionTypeEnum.QUICKLY_ANSWER.getType().equals(type)) {
            List<QuicklyAnswer> quicklyAnswerList = quicklyAnswerService.list();
            for (QuicklyAnswer quicklyAnswer : quicklyAnswerList) {
                QuestionVo questionVo = new QuestionVo();
                BeanUtils.copyProperties(quicklyAnswer, questionVo);
                questionVoList.add(questionVo);
            }
        }
        //如果传参不对，返回空值
        if (questionVoList.isEmpty()) {
            return null;
        }
        return questionVoList;
    }

    /**
     * 插入一条数据
     * @param titleId 题目id
     * @param answer 对还是错
     * @param score 题目分数
     * @param type 题目类型
     * @return
     */
    public boolean insertRecord(Integer titleId, String answer, Integer score,String type){
        TeamScoreRecord teamScoreRecord=new TeamScoreRecord();
        teamScoreRecord.setTitleId(titleId);
        teamScoreRecord.setType(type);
        //如果对
        if (RightOrWrongEnum.RIGHT.getResult().equals(answer)){
            teamScoreRecord.setScore(score);
        }
        //错
        if (RightOrWrongEnum.WRONG.getResult().equals(answer)){
            teamScoreRecord.setScore(-score);
        }
        //获取有多少支队伍
        int teamCount = teamService.count();
        //求余
        int i = titleId % teamCount;
        Team team=new Team();
        //获取team
        switch (i) {
            case 1:
                team = teamService.getById(1);
                break;
            case 2:
                team = teamService.getById(2);
                break;
            case 3:
                team = teamService.getById(3);
                break;
            case 4:
                team = teamService.getById(4);
                break;
            case 5:
                team = teamService.getById(5);
                break;
            case 0:
                if(teamCount==4){
                    team = teamService.getById(4);
                }
                if(teamCount==6){
                    team = teamService.getById(6);
                }
                break;
            default:
                break;
        }
        //验证 set
        if(StringUtils.isNotBlank(team.getName())){
            teamScoreRecord.setName(team.getName());
        }
        return teamScoreRecordService.save(teamScoreRecord);
    }
}
