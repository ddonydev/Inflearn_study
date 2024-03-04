package com.group.attendanceapp.team.dto.request;

import lombok.Getter;

@Getter
public class RegisterTeamRequest {
    private long id;
    private String name;
    private String manager;
    private long memberCnt;

}
