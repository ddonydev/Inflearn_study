package com.group.attendanceapp.team.dto.response;

import lombok.Getter;

@Getter
public class TeamListResponse {
    private String name;
    private String manager;
    private long memberCnt;

    public TeamListResponse(String name, String manager, long memberCnt) {
        this.name = name;
        this.manager = manager;
        this.memberCnt = memberCnt;
    }

}
