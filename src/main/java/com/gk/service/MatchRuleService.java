package com.gk.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gk.mapper.MatchRuleMapper;
import com.gk.model.MatchRule;
import org.springframework.stereotype.Service;

/**
 * @Author: 卖女孩的小火柴999
 * @Date: 2019-03-27 17:10
 */
@Service
public class MatchRuleService extends ServiceImpl<MatchRuleMapper, MatchRule> {

    /**
     * 根据题型 获取单条规则
     * @param type
     * @return
     */
    public MatchRule getOneRule(String type){
        QueryWrapper<MatchRule> wrapper=new QueryWrapper<>();
        wrapper.eq("type",type);
        return this.baseMapper.selectOne(wrapper);
    }
}
