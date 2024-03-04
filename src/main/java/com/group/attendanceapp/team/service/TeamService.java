package com.group.attendanceapp.team.service;

import com.group.attendanceapp.team.domain.Team;
import com.group.attendanceapp.team.domain.TeamRepository;
import com.group.attendanceapp.team.dto.request.RegisterTeamRequest;
import com.group.attendanceapp.team.dto.response.TeamListResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public List<TeamListResponse> selectTeamList() {
        return repository.findAll().stream()
                .map(team -> new TeamListResponse(team.getName(), team.getManager(), team.getEmployeeCnt()))
                .collect(Collectors.toList());
    }

    public void insertTeam(RegisterTeamRequest request) {
        repository.findByName(request.getName()).ifPresent(team -> {
            throw new IllegalArgumentException("이미 존재하는 팀 입니다.");
        });

        repository.save(new Team(request.getName(), request.getManager(), request.getMemberCnt()));
    }

    @Transactional
    public void updateEmployeeCnt(String teamName) {
        Team team = findTeamByName(teamName);
        team.updateEmployeeCnt();
    }

    @Transactional
    public void updateManager(String teamName, String name) {
        Team team = findTeamByName(teamName);
        team.updateManager(name);
    }

    private Team findTeamByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 팀 입니다."));
    }
}
