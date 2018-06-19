package com.personal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 李亚卿
 * @Date: Created in 19:03 2018/6/18 0018
 * @Description: 更新用户信用。记录用户的活动信用记录
 */
@Mapper
public interface CreditMapper {
    /**
     * 插入信用记录
     *
     * @param userId
     * @param activityId
     * @param type
     */
    void insert(String userId, String activityId, String type);

    /**
     * 获取某条信用记录
     *
     * @param userId
     * @param activityId
     * @return
     */
    int get(String userId, String activityId);

    /**
     * 获取某个用户的信用记录
     *
     * @param userId
     * @param type   1用户的失约次数 2用户的取消次数
     * @return
     */
    int getCreditNum(@Param("userId") String userId, @Param("type") String type);
}
