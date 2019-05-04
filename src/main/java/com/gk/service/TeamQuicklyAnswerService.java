package com.gk.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.mapper.TeamQuicklyAnswerMapper;
import com.gk.model.TeamQuicklyAnswer;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-21 16:21
 */
@Service
public class TeamQuicklyAnswerService extends ServiceImpl<TeamQuicklyAnswerMapper, TeamQuicklyAnswer> {

    private Integer id;

    /**
     * 插入抢答题参赛团队
     * @param name
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer insertTeam(String name){
        if(StringUtils.isNotBlank(name)){
            TeamQuicklyAnswer teamQuicklyAnswer=new TeamQuicklyAnswer();
            teamQuicklyAnswer.setName(name);
            teamQuicklyAnswer.setScore(0);
            //插入成功则返回id
            id = this.save(teamQuicklyAnswer) ? teamQuicklyAnswer.getId() : null;
            return id;
        }
        return null;
    }

    //返回插入的数据的name
    public String getAnswerName(){
        if(id!=null){
            return this.getById(id).getName();
        }
        return null;
    }
}
