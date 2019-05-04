package com.gk.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.enums.RightOrWrongEnum;
import com.gk.mapper.TeamMapper;
import com.gk.model.Team;
import org.springframework.stereotype.Service;

/**
 * @Author: 卖女孩的小火柴
 * @Date: 2019-03-21 16:20
 */
@Service
public class TeamService extends ServiceImpl<TeamMapper, Team> {

    /**
     * 必答题计分 todo 新建一个表 插入数据记录
     * @param titleId 题号
     * @param answer 答案（对或错）
     * @param score 题目的分数
     * @return
     */
    public boolean countScore(Integer titleId, String answer, Integer score) {
        //操作的队伍
        Team team = null;
        //取余数 0 1 2 3
        //this.count() 参赛选手的数量 team表
        int i = titleId % this.count();
        //余数为1则第一支队伍加分
        //余数为0则最后一支支队伍加分
        switch (i) {
            case 1:
                team = this.getById(1);
                break;
            case 2:
                team = this.getById(2);
                break;
            case 3:
                team = this.getById(3);
                break;
            case 4:
                team = this.getById(4);
                break;
            case 5:
                team = this.getById(5);
                break;
            case 0:
                if(this.count()==4){
                    team = this.getById(4);
                }
                if(this.count()==6){
                    team = this.getById(6);
                }
                break;
            default:
                break;
        }
        //用equals而不能用==
        if (RightOrWrongEnum.RIGHT.getResult().equals(answer)) {
            team.setScore(team.getScore() + score);
        }
        if (RightOrWrongEnum.WRONG.getResult().equals(answer)) {
            int i1 = team.getScore() - score;
            //分数不能小于0
            if (i1 <= 0) {
                team.setScore(0);
            }
            if (i1 > 0) {
                team.setScore(team.getScore() - score);
            }

        }
        //更新参赛队伍数据
        return this.updateById(team);
    }
}
