package com.amos.im.core.attribute;

import com.amos.im.core.vo.GroupInfoVO;
import com.amos.im.core.vo.LoginInfoVO;
import io.netty.util.AttributeKey;

import java.util.Map;

/**
 * PROJECT: im
 * DESCRIPTION: 客户端Channel里存储数据常量
 *
 * @author Daoyuan
 * @date 2019/3/20
 */
public interface ImAttribute {

    /**
     * 客户端留存登录信息
     */
    AttributeKey<LoginInfoVO> LOGIN_INFO = AttributeKey.newInstance("login");
    /**
     * 客户端留存群组信息
     */
    AttributeKey<Map<String, GroupInfoVO>> GROUP_INFO_MAP = AttributeKey.newInstance("joinedGroups");

}