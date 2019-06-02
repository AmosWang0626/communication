package com.amos.im.web.console;

import com.amos.im.core.request.GroupQuitRequest;
import io.netty.channel.Channel;

/**
 * PROJECT: im
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/26
 */
public class ConsoleCmdGroupQuit extends BaseConsole {

    @Override
    void exec(Channel channel) {
        System.out.print("请输入群聊ID: ");
        String groupId = sc.next();

        GroupQuitRequest quitRequest = new GroupQuitRequest();
        quitRequest.setGroupId(groupId);

        channel.writeAndFlush(quitRequest);
    }

}