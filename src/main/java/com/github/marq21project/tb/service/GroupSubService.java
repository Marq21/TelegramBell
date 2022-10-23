package com.github.marq21project.tb.service;

import com.github.marq21project.tb.client.dto.GroupDiscussionInfo;
import com.github.marq21project.tb.repository.GroupSub;

import java.util.List;
import java.util.Optional;

public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);

    GroupSub save(GroupSub groupSub);

    Optional<GroupSub> findById(Integer id);

    List<GroupSub> findAll();
}
