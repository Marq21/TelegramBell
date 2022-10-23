package com.github.marq21project.tb.client.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@Builder
@Getter
public class GroupCountRequestArgs {

    private final String query;
    private final GroupInfoType type;
    private final GroupFilter filter;

    public Map populateQueries() {
        Map<Object, Object> queries = new HashMap<>();
        if (nonNull(query)) {
            queries.put("query", query);
        }
        if (nonNull(type)) {
            queries.put("type", type);
        }
        if (nonNull(filter)) {
            queries.put("filter", filter);
        }
        return queries;
    }
}
