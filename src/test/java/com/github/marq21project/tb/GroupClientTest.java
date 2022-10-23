package com.github.marq21project.tb;

import com.github.marq21project.tb.client.GroupClient;
import com.github.marq21project.tb.client.GroupClientImpl;
import com.github.marq21project.tb.client.dto.GroupCountRequestArgs;
import com.github.marq21project.tb.client.dto.GroupDiscussionInfo;
import com.github.marq21project.tb.client.dto.GroupInfo;
import com.github.marq21project.tb.client.dto.GroupRequestArgs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.github.marq21project.tb.client.dto.GroupInfoType.TECH;

@DisplayName("Integration-level testing for GroupClientImplTest")
public class GroupClientTest {

    private final GroupClient groupClient = new GroupClientImpl("https://javarush.ru/api/1.0/rest");

    @Test
    public void shouldProperlyGetGroupsWithEmptyArgs() {

        GroupRequestArgs args = GroupRequestArgs.builder().build();

        List<GroupInfo> groupList = groupClient.getGroupList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    public void shouldProperlyGetWithOffSetAndLimit() {

        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();

        List<GroupInfo> groupList = groupClient.getGroupList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    public void shouldProperlyGetGroupsDiscWithEmptyArgs() {

        GroupRequestArgs args = GroupRequestArgs.builder().build();

        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    public void shouldProperlyGetGroupDiscWithOffSetAndLimit() {

        GroupRequestArgs args = GroupRequestArgs.builder()
                .offset(1)
                .limit(3)
                .build();

        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);

        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    public void shouldProperlyGetGroupCount() {
        //given
        GroupCountRequestArgs args = GroupCountRequestArgs.builder().build();

        //when
        Integer groupCount = groupClient.getGroupCount(args);

        //then
        Assertions.assertEquals(32, groupCount);
    }

    @Test
    public void shouldProperlyGetGroupTECHCount() {
        //given
        GroupCountRequestArgs args = GroupCountRequestArgs.builder()
                .type(TECH)
                .build();

        //when
        Integer groupCount = groupClient.getGroupCount(args);

        //then
        Assertions.assertEquals(7, groupCount);
    }

    @Test
    public void shouldProperlyGetGroupById() {
        //given
        Integer androidGroupId = 16;

        //when
        GroupDiscussionInfo groupById = groupClient.getGroupById(androidGroupId);

        //then
        Assertions.assertNotNull(groupById);
        Assertions.assertEquals(16, groupById.getId());
        Assertions.assertEquals(TECH, groupById.getType());
        Assertions.assertEquals("android", groupById.getKey());
    }
}
