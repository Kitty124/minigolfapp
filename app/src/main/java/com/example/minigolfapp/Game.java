package com.example.minigolfapp;

import java.util.ArrayList;

public class Game {

    private static int CURRENT_GAME_ID = 0;
    private int gameID;
    private boolean isActive;
    private boolean parsActive;
    private ArrayList<Player> players;
    private ArrayList<int[]> playerScores;
    private String fileName;
    private int currentHole;
    private int numHoles;
    public int currentPlayerTurn = 0;
    private int[] pars = null;

    public static Game currentGame = null;

    public Game(ArrayList<Player> players, int numHoles, int[] pars){
        if(parsActive)
            this.pars = pars;

        this.gameID = CURRENT_GAME_ID + 1;
        CURRENT_GAME_ID = gameID;
        this.playerScores = new ArrayList<>(players.size());
        this.players = players;
        this.numHoles = numHoles;
        isActive = true;
        currentHole = 1;
    }

    public Game(ArrayList<Player> players, int numHoles, String fileName){
        if(parsActive)
            pars = new int[numHoles];

        this.gameID = CURRENT_GAME_ID + 1;
        CURRENT_GAME_ID = gameID;
        this.playerScores = new ArrayList<>(players.size());
        this.players = players;
        this.numHoles = numHoles;
        this.fileName = fileName;
        isActive = true;
        currentHole = 1;
    }

    public int getCurrentHole() {
        return currentHole;
    }

    public void setCurrentHole(int currentHole) {
        this.currentHole = currentHole;
    }

    public void setNumHoles(int numHoles) {
        this.numHoles = numHoles;
    }

    public int getNumHoles() {
        return numHoles;
    }

    public void setActive(boolean active) {
        isActive = active;
        //if active = false, save game as csv file
    }

    public boolean getActive() {
        return isActive;
    }

    public String getFileName(){
        return this.fileName;
    }

    public void setPars(int[] pars) {
        this.pars = pars;
    }

    public int[] getPars() {
        return pars;
    }

    public void setParsActive(boolean parsActive) {
        this.parsActive = parsActive;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p) {
        this.players.add(p);
    }

    public void removePlayer(String playerID) {
        this.players.remove(playerID);
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
