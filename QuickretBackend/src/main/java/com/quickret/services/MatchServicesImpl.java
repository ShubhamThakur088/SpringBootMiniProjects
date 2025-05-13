package com.quickret.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.quickret.apis.entities.Match;
import com.quickret.apis.repository.*;

@Service
public class MatchServicesImpl implements MatchService{
	
	private MatchRepo matchRepo;
	
	public MatchServicesImpl(MatchRepo matchRepo) {
		this.matchRepo = matchRepo;
	}

	@Override
	public List<Match> getAllMatches() {
		// TODO Auto-generated method stub
		return this.matchRepo.findAll();
	}

	@Override
	public List<Match> getAllLiveMatches() {
		String url = "https://www.cricbuzz.com/cricket-match/live-scores";
		List<Match> matches = new ArrayList<>();
		
		try {
			Document document = Jsoup.connect("https://www.cricbuzz.com/cricket-match/live-scores")
				    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
				    .timeout(10 * 1000)  // Optional: increase timeout
				    .get();
			Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-col.cb-col-100.cb-tms-itm");
			
			for(Element element : liveScoreElements) {
				HashMap<String, String> liveMatchData = new LinkedHashMap<>();
				String teamHeading = element.select("h3.cb-lv-scr-mtch-hdr.inline-block").select("a.text-hvr-underline.text-bold").text();				
				
				String matchLocation = element.select("span.text-gray").text();				
				Elements bowlingTeamData = element.select("div.cb-col");
				String bolwingTeamName = bowlingTeamData.select("div.cb-scr-wll-chvrn.cb-lv-scrs-col").select("div.cb-hmscg-bwl-txt.cb-ovr-flo").select("div.cb-ovr-flo.cb-hmscg-tm-nm").text();
				String bowlingTeamRuns = bowlingTeamData.select("div.cb-scr-wll-chvrn.cb-lv-scrs-col").select("div.cb-hmscg-bwl-txt.cb-ovr-flo").select("div.cb-ovr-flo").text();
//				
				Elements battingTeamData = element.select("div.cb-col");
				String battingTeamName = battingTeamData.select("div.cb-hmscg-bat-txt ").select("div.cb-ovr-flo.cb-hmscg-tm-nm").text();
				String battingTeamRuns = battingTeamData.select("div.cb-hmscg-bat-txt ").select("div.cb-ovr-flo").text();
				String matchStatus = element.select("div.cb-col-100.cb-col.cb-schdl").select("a.cb-lv-scrs-well.cb-lv-scrs-well-complete").select("div.cb-col")
											.select("div.cb-scr-wll-chvrn.cb-lv-scrs-col").select("div.cb-text-complete").text();
				
				Match match = new Match();
				
				match.setTeamHeading(teamHeading);
				match.setMatchNumberWithVenue(matchLocation.replace("(Suspended)", ""));
				match.setMatchStatus(matchStatus);
				
								
				match.setBattingTeam(battingTeamName);
				match.setBattingTeamRuns(battingTeamRuns);
				match.setBowlingTeam(bolwingTeamName);
				match.setBowlingTeamRuns(bowlingTeamRuns);
				
				matches.add(match);
				
				updateMatchInDB(match);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return matches;
	}
	
	private void updateMatchInDB(Match match1) {
		Match match = this.matchRepo.findByTeamHeading(match1.getTeamHeading()).orElse(null);
		
		if(match == null) {
			matchRepo.save(match1);
		}
		else {
			match1.setMatchId(match.getMatchId());
			matchRepo.save(match1);
		}
	}

}
