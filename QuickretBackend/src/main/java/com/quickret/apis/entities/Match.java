package com.quickret.apis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "matchId",
    "teamHeading",
    "matchNumberWithVenue",
    "battingTeam",
    "battingTeamRuns",
    "bowlingTeam",
    "bowlingTeamRuns",    
    "status",
    "date"
})
@Entity
@Table(name = "cricket_matches")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matchId;

	private String teamHeading;
	private String matchNumberWithVenue;
	private String battingTeam;
	private String battingTeamRuns;
	private String bowlingTeam;
	private String bowlingTeamRuns;
	
	
		
	private String status;

	private Date date = new Date();

	public Match(String teamHeading, String matchNumberWithVenue, String battingTeam,
			String battingTeamRuns, String bowlingTeam, String bowlingTeamRuns,	String status, Date date) {
		super();
		
		this.teamHeading = teamHeading;
		this.matchNumberWithVenue = matchNumberWithVenue;
		this.battingTeam = battingTeam;
		this.battingTeamRuns = battingTeamRuns;
		this.bowlingTeam = bowlingTeam;
		this.bowlingTeamRuns = bowlingTeamRuns;		
		this.status = status;
		this.date = date;
	}

	public Match() {}
	
	public void setMatchStatus(String status) {
		this.status = status;
	}
	
	public String getMatchStatus() {
		return status;
	}

	public String getTeamHeading() {
		return teamHeading;
	}

	public void setTeamHeading(String teamHeading) {
		this.teamHeading = teamHeading;
	}

	public String getMatchNumberWithVenue() {
		return matchNumberWithVenue;
	}

	public void setMatchNumberWithVenue(String matchNumberWithVenue) {
		this.matchNumberWithVenue = matchNumberWithVenue;
	}

	public String getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	public String getBattingTeamRuns() {
		return battingTeamRuns;
	}

	public void setBattingTeamRuns(String battingTeamRuns) {
		this.battingTeamRuns = battingTeamRuns;
	}

	public String getBowlingTeam() {
		return bowlingTeam;
	}

	public void setBowlingTeam(String bowlingTeam) {
		this.bowlingTeam = bowlingTeam;
	}

	public String getBowlingTeamRuns() {
		return bowlingTeamRuns;
	}

	public void setBowlingTeamRuns(String bowlingTeamRuns) {
		this.bowlingTeamRuns = bowlingTeamRuns;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	@Override
	public String toString() {
		return "Match [matchId=" + matchId + ", teamHeading=" + teamHeading + ", matchNumberWithVenue="
				+ matchNumberWithVenue + ", battingTeam=" + battingTeam + ", battingTeamRuns=" + battingTeamRuns
				+ ", bowlingTeam=" + bowlingTeam + ", bowlingTeamRuns=" + bowlingTeamRuns + ", status=" + status
				+ ", date=" + date + "]";
	}
	
}
