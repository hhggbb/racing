package com.gk.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.mapper.TeamScoreRecordMapper;
import com.gk.model.TeamScoreRecord;
import org.springframework.stereotype.Service;

/**
 * @Author: 卖女孩的小火柴999
 * @Date: 2019-03-28 17:16
 */
@Service
public class TeamScoreRecordService extends ServiceImpl<TeamScoreRecordMapper, TeamScoreRecord> {

    /**
     * 插入一条数据
     * @param titleId 题目id
     * @param answer 对还是错
     * @param score 题目分数
     * @param type 题目类型
     * @return
     */
//    public boolean insertRecord(Integer titleId, String answer, Integer score,String type){
//        TeamScoreRecord teamScoreRecord=new TeamScoreRecord();
//        teamScoreRecord.setTitleId(titleId);
//        teamScoreRecord.setType(type);
//        teamScoreRecord.setName("小白");
//        teamScoreRecord.setScore(-10);
//        return this.save(teamScoreRecord);
//    }
}
