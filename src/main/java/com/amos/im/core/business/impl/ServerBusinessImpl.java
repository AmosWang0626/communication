package com.amos.im.core.business.impl;

import com.amos.im.common.util.RedisUtil;
import com.amos.im.core.business.ServerBusiness;
import com.amos.im.core.constant.RedisKeys;
import com.amos.im.core.service.ServerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * PROJECT: Sales
 * DESCRIPTION: 服务端核心业务
 *
 * @author amos
 * @date 2019/6/1
 */
@Service("serverBusiness")
public class ServerBusinessImpl implements ServerBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerBusinessImpl.class);

    @Resource
    private ServerService serverService;


    @Override
    public void start() {
        serverService.start();
    }

    @Override
    public List<String> logs() {

        return RedisUtil.lrange(RedisKeys.SERVER_RUN_LOG, 0, -1);
    }
}