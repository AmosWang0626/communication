package com.amos.im.controller.request;

import com.amos.im.common.BasePacket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * PROJECT: im
 * DESCRIPTION: note
 *
 * @author Daoyuan
 * @date 2019/3/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class GroupJoinResponse extends BasePacket {

    private String groupId;

    private String groupName;

    private Boolean success;

    private String sponsorName;

    private List<String> nicknameList;

    private Date createTime;

    @Override
    public Byte getCommand() {
        return Command.GROUP_JOIN_RESPONSE;
    }
}