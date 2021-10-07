package com.codecool.leaguestatistics.controller;

import com.codecool.leaguestatistics.Utils;
import com.codecool.leaguestatistics.factory.LeagueFactory;
import com.codecool.leaguestatistics.model.Player;
import com.codecool.leaguestatistics.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides all necessary methods for season simulation
 */
public class Season {

    private List<Team> league;

    public Season() {
        league = new ArrayList<>();
    }

    /**
     * Fills league with new teams and simulates all games in season.
     * After all games played calls table to be displayed.
     */
    public void run() {
        this.league = LeagueFactory.createLeague(6);
        playAllGames();
        // Call Display methods below

    }

    /**
     * Playing whole round. Everyone with everyone one time. Number of teams in league should be even.
     * Following solution represents the robin-round tournament.
     */
    private void playAllGames() {
        throw new RuntimeException("playAllGames method not implemented");
    }

    /**
     * Plays single game between two teams and displays result after.
     */
    private void playMatch(Team team1, Team team2) {
        int chanceTeamOneToGoal;
        int chanceTeamTwoToGoal;
        int resultTeamOne = 0;
        int resultTeamTwo = 0;
        for(int i = 0; i < 3; i++ ) {
            chanceTeamOneToGoal = 0;
            chanceTeamTwoToGoal = 0;

            for(Player player: team1.getPlayers()) {
                chanceTeamOneToGoal += player.getSkillRate() + Utils.getRandomValue(1,100);
            }

            for(Player player: team2.getPlayers()) {
                chanceTeamTwoToGoal += player.getSkillRate() + Utils.getRandomValue(1,100);
            }

            if (chanceTeamOneToGoal > chanceTeamTwoToGoal) resultTeamOne++;
            else if (chanceTeamOneToGoal < chanceTeamTwoToGoal) resultTeamTwo++;
            else {resultTeamOne++; resultTeamTwo++;}
        }

    }

    /**
     * Checks for each player of given team chance to score based on skillrate.
     * Adds scored goals to player's and team's statistics.
     * @return All goals scored by the team in current game
     */
    private int getScoredGoals(Team team) {
        //throw new RuntimeException("getScoredGoals method not implemented");
        int chanceToGoal = Utils.getRandomValue(1,100);
        int goals = 0;
        for(Player player : team.getPlayers()) {
            if (player.getSkillRate() > chanceToGoal) {
                player.setGoals(player.getGoals() + 1);
                goals++;
            }
        }
        return goals;
    }
}
