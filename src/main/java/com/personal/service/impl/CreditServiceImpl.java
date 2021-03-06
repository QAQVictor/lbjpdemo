package com.personal.service.impl;

import com.personal.dao.CreditMapper;
import com.personal.model.DO.CreditDO;
import com.personal.service.CreditService;
import com.society.dao.ActivityMapper;
import com.user.model.DO.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 李亚卿
 * @Date: Created in 23:22 2018/6/20 0020
 * @Description:
 */
@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditMapper creditMapper;
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Map getCreditNum(String userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("breakNum", creditMapper.getCreditNum(userId, "1"));
        map.put("entryNum", activityMapper.getJoinActivityNum(userId));
        map.put("cancelNum", creditMapper.getCreditNum(userId, "2"));
        map.put("createNum", activityMapper.getCreateActivityNum(userId));
        return map;
    }

    @Override
    public void addCredit(CreditDO credit) {
        if (creditMapper.get(credit.getUserId(), credit.getActivityId()) == null)
            creditMapper.insert(credit);
    }

    @Override
    public CreditDO get(CreditDO credit) {
        return creditMapper.get(credit.getUserId(), credit.getActivityId());
    }
}
