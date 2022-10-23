package com.github.marq21project.tb.client;

import com.github.marq21project.tb.client.dto.*;
import kong.unirest.GenericType;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Component
public class GroupClientImpl implements GroupClient {

    private final String groupPath;
    private final String getPostPath;

    public GroupClientImpl(@Value("${javarush.api.path}") String javarushApi) {
        this.groupPath = javarushApi + "/groups";
        this.getPostPath = javarushApi + "/posts";
    }


    @Override
    public List<GroupInfo> getGroupList(GroupRequestArgs requestArgs) {
        return Unirest.get(groupPath)
                .queryString(requestArgs.populateQueries())
                .asObject(new GenericType<List<GroupInfo>>() {
                })
                .getBody();
    }

    @Override
    public List<GroupDiscussionInfo> getGroupDiscussionList(GroupRequestArgs requestArgs) {
        return Unirest.get(groupPath)
                .queryString(requestArgs.populateQueries())
                .asObject(new GenericType<List<GroupDiscussionInfo>>() {
                })
                .getBody();
    }

    @Override
    public Integer getGroupCount(GroupCountRequestArgs countRequestArgs) {
        return Integer.valueOf(
                Unirest.get(String.format("%s/count", groupPath))
                        .queryString(countRequestArgs.populateQueries())
                        .asString()
                        .getBody()
        );
    }


    @Override
    public GroupDiscussionInfo getGroupById(Integer id) {
        return Unirest.get(String.format("%s/group%s", groupPath, id.toString()))
                .asObject(GroupDiscussionInfo.class)
                .getBody();
    }

    @Override
    public Integer findLastPostId(Integer groupSubId) {
        List<PostInfo> posts = Unirest.get(getPostPath)
                .queryString("order", "NEW")
                .queryString("groupKid", groupSubId.toString())
                .queryString("limit", "1")
                .asObject(new GenericType<List<PostInfo>>() {
                })
                .getBody();
        return isEmpty(posts) ? 0 : Optional.ofNullable(posts.get(0)).map(PostInfo::getId).orElse(0);
    }
}
