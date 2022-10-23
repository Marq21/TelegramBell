package com.github.marq21project.tb.client;

import com.github.marq21project.tb.client.dto.GroupCountRequestArgs;
import com.github.marq21project.tb.client.dto.GroupDiscussionInfo;
import com.github.marq21project.tb.client.dto.GroupInfo;
import com.github.marq21project.tb.client.dto.GroupRequestArgs;

import java.util.List;

public interface GroupClient {

    List<GroupInfo> getGroupList(GroupRequestArgs requestArgs);

    List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs);

    Integer getGroupCount(GroupCountRequestArgs countRequestArgs);

    GroupDiscussionInfo getGroupById(Integer id);

    Integer findLastPostId(Integer groupSub);
}
