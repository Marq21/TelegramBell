package com.github.marq21project.tb.client.dto;

import lombok.Data;

@Data
public class BaseUserInfo {
    private String city;
    private String country;
    private String displayName;
    private Integer id;
    private String job;
    private String key;
    private Integer level;
    private String pictureUrl;
    private String position;
    private UserPublicStatus publicStatus;
    private String publicStatusMessage;
    private Integer rating;
    private Integer userId;
}
