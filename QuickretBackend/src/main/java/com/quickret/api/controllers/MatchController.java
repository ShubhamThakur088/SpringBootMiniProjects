package com.quickret.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickret.apis.entities.Match;
import com.quickret.services.MatchService;


@RestController
@RequestMapping(path = "match")
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	public MatchController(MatchService matchService) {
		this.matchService = matchService;
	}
	
	@GetMapping("/live")
	public ResponseEntity<List<Match>> getAllLiveMatches(){
		System.out.println("success!");
		return new ResponseEntity<>(this.matchService.getAllLiveMatches(),HttpStatus.OK); 
	}
}
