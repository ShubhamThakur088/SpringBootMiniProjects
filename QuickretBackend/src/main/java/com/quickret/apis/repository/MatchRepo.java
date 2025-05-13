package com.quickret.apis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickret.apis.entities.Match;

public interface MatchRepo extends JpaRepository<Match, Integer>{
	
	Optional<Match> findByTeamHeading(String teamHeading);

}
