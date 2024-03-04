package com.group.attendanceapp.team.controller;

import com.group.attendanceapp.team.dto.request.RegisterTeamRequest;
import com.group.attendanceapp.team.dto.response.TeamListResponse;
import com.group.attendanceapp.team.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance/team")
public class TeamController {
    private final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @PostMapping("/resister_team")
    public void resisterTeam(@RequestBody RegisterTeamRequest request) {
        service.insertTeam(request);
    }

    @GetMapping("/team")
    public List<TeamListResponse> teamList() {
        return service.selectTeamList();
    }
}
