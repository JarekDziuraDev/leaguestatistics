package com.codecool.leaguestatistics.model;

import com.codecool.leaguestatistics.factory.NamesGenerator;

import java.util.Comparator;
import java.util.List;

/**
 * Represents a team.
 */
public class Team implements Comparable<Team> {

    private String name;
    private Division division;
    private int wins;
    private int draws;
    private int loses;
    private List<Player> players;

    public Team(Division division, List<Player> players) {
        this.name = NamesGenerator.getTeamName();
        this.division = division;
        this.players = players;
    }

    public Team() {
    }

    /**
     * Helper method that finds best player with most scored goals in team
     */
    public Player getBestPlayer() {
        Player bestPlayer = new Player(0);
        bestPlayer.setName("");
        for (Player player : players) {
            if (player.getGoals() > bestPlayer.getGoals()) {
                bestPlayer = player;
            }
        }
        return bestPlayer;
    }

    /**
     * CurrentPoints is a sum of wins and draws points. For each win 3 points, for draw 1 point.
     */
    public int getCurrentPoints() {
        return (wins * 3) + draws;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    @Override
    public int compareTo(Team o) {
        if(this.getWins() < o.getWins()) return -1;
        if(this.getWins() > o.getWins()) return 1;
        else return 0;
    }
}
