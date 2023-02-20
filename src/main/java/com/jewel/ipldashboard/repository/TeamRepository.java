package com.jewel.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.jewel.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team,Long>{
	Team getByTeamName(String teamName);

}
