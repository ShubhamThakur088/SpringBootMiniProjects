package com.quickret.services;

import java.util.List;
import java.util.Map;

import com.quickret.apis.entities.Match;

public interface MatchService {
	
	List<Match> getAllMatches();	
	List<Match> getAllLiveMatches();	
}
