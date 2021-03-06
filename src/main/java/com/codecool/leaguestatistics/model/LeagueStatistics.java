package com.codecool.leaguestatistics.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Provides all necessary statistics of played season.
 */
public class LeagueStatistics {

    /**
     * Gets all teams with highest points order, if points are equal next deciding parameter is sum of goals of the team.
     */
    public static List<Team> getAllTeamsSorted(List<Team> teams) {
        //throw new RuntimeException("getAllPlayers method not implemented");
        List<Team> sortedListOfTeam = new ArrayList<>();
        Collections.copy(sortedListOfTeam, teams);
        Collections.sort(sortedListOfTeam);
        
        return  sortedListOfTeam;
    }

    /**
     * Gets all players from each team in one collection.
     */
    public static List<Player> getAllPlayers(List<Team> teams) {
        //throw new RuntimeException("getAllPlayers method not implemented");
        List<Player> resultListPlayer = new ArrayList<>();

        teams.forEach(team -> {
            team.getPlayers().forEach(player -> {
                resultListPlayer.add(player);
            });
        });
        return resultListPlayer;
    }

    /**
     * Gets team with the longest name
     */
    public static Team getTeamWithTheLongestName(List<Team> teams) {
        //throw new RuntimeException("getTeamWithTheLongestName method not implemented");
        Team teamWithTheLongestName = new Team();
        teamWithTheLongestName.setName("");
        for (Team team : teams) {
            if(team.getName().length() > teamWithTheLongestName.getName().length()) {
                teamWithTheLongestName = team;
            }
        }
        return teamWithTheLongestName;
    }

    /**
     * Gets top teams with least number of lost matches.
     * If the amount of lost matches is equal, next deciding parameter is team's current points value.
     * @param teamsNumber The number of Teams to select.
     * @return Collection of selected Teams.
     */
    public static List<Team> getTopTeamsWithLeastLoses(List<Team> teams, int teamsNumber) {
        throw new RuntimeException("getTopTeamsWithLeastLoses method not implemented");


    }

    /**
     * Gets a player with the biggest goals number from each team.
     */
    public static List<Player> getTopPlayersFromEachTeam(List<Team> teams) {
        List<Player> playersWithBiggestGoalsFromEachTeam = new ArrayList<>();

        for(Team team: teams) {
            playersWithBiggestGoalsFromEachTeam.add(team.getBestPlayer());
        }
        //Collections.reverse(playersWithBiggestGoalsFromEachTeam);
        return playersWithBiggestGoalsFromEachTeam;
    }

    /**
     * Gets all teams, where there are players with no scored goals.
     */
    public static List<Team> getTeamsWithPlayersWithoutGoals(List<Team> teams){
        List<Team> teamWithNoScoredGoalsPLayers = new ArrayList<>();
        boolean noScoredGoals;

        for (Team team : teams) {
            noScoredGoals = true;
            for (Player player : team.getPlayers()) {
                if(player.getGoals() <= 0) {
                    teamWithNoScoredGoalsPLayers.add(team);
                    break;
                }
            }
        }
        return teamWithNoScoredGoalsPLayers;
    }

    /**
     * Gets players with given or higher number of goals scored.
     * @param goals The minimal number of goals scored.
     * @return Collection of Players with given or higher number of goals scored.
     */
    public static List<Player> getPlayersWithAtLeastXGoals(List<Team> teams, int goals) {
        //throw new RuntimeException("getPlayersWithAtLeastXGoals method not implemented");
        List<Player> playersWithGivenOrHigherGoals = new ArrayList<>();
        for (Team team : teams) {
            for (Player player : team.getPlayers()) {
                if(player.getGoals() >= goals) {
                    playersWithGivenOrHigherGoals.add(player);
                }
            }
        }
        return playersWithGivenOrHigherGoals;
    }

    /**
     * Gets the player with the highest skill rate for given Division.
     */
    public static Player getMostTalentedPlayerInDivision(List<Team> teams, Division division) {
        //throw new RuntimeException("getMostTalentedPlayerInDivision method not implemented");
        Player bestPlayer = new Player(0, "John Wick");
        for (Team team : teams) {
            if(team.getDivision() == division) {
                bestPlayer = team.getBestPlayer();
            }
        }
        return bestPlayer;
    }

    /**
     * OPTIONAL
     * Returns the division with greatest amount of points.
     * If there is more than one division with the same amount current points, then check the amounts of wins.
     */

    private static class DivWithScore {
        public Division division;
        public int score;
        public int wins;
        DivWithScore() {};

        DivWithScore(Division division, int score, int wins) {
            this.division = division;
            this.score = score;
            this.wins = wins;
        }
    }
    public static Division getStrongestDivision(List<Team> teams) {
        List<DivWithScore> divWithScores = new ArrayList<>();
        DivWithScore strongestDivision = new DivWithScore();
        for (Team team : teams) {
            switch (team.getDivision()) {
                case East: divWithScores.add(new DivWithScore(Division.East, team.getCurrentPoints(), team.getWins())); break;
                case West: divWithScores.add(new DivWithScore(Division.West, team.getCurrentPoints(), team.getWins())); break;
                case Central: divWithScores.add(new DivWithScore(Division.Central, team.getCurrentPoints(), team.getWins())); break;
            }
        }

        for (DivWithScore divWithScore : divWithScores) {

            if (divWithScore.score >= strongestDivision.score) {
                if (divWithScore.score == strongestDivision.score) {
                    if (divWithScore.wins > strongestDivision.wins) {
                        strongestDivision = divWithScore;
                    }
                } else strongestDivision = divWithScore;
            }

        }
        return strongestDivision.division;
    }
}
