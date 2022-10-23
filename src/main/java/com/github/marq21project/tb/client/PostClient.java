package com.github.marq21project.tb.client;

import com.github.marq21project.tb.client.dto.PostInfo;

import java.util.List;

public interface PostClient {

    /**
     * Find new posts since lastPostId in provided group.
     *
     * @param groupId provided group ID.
     * @param lastPostId provided last post ID.
     * @return the collection of the new {@link PostInfo}.
     */
    List<PostInfo> findNewPosts(Integer groupId, Integer lastPostId);
}
