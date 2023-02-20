package com.jewel.ipldashboard.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jewel.ipldashboard.model.Match;
import com.jewel.ipldashboard.model.Team;
import com.jewel.ipldashboard.repository.MatchRepository;
import com.jewel.ipldashboard.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
	
	TeamRepository teamRepo;
	MatchRepository matchRepo;

	public TeamController(TeamRepository teamRepo,MatchRepository matchRepo) {
		super();
		this.teamRepo = teamRepo;
		this.matchRepo = matchRepo;

	}
	
	@GetMapping("/team/{teamName}")
	public Team displayTeam(@PathVariable String teamName) 
	{
		Team team=this.teamRepo.getByTeamName(teamName);
		team.setMatches(matchRepo.getLatestMatches(teamName,4));
		return team;
		
	}

	@GetMapping("/team/{teamName}/matches")
	public List<Match> getMatchesForTeam(@PathVariable String teamName ,@RequestParam int year ) 
	{
		LocalDate startDate=LocalDate.of(year, 1, 1);
		LocalDate endDate=LocalDate.of(year+1, 1, 1);
     
		return matchRepo.getMatchesByTeamBetweenDates(teamName,startDate,endDate);
	   
		/*return	matchRepo.getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
			teamName,startDate,endDate,
			teamName,startDate,endDate);*/
	}
	

}
