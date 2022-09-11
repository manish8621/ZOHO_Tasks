package com.cricket;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Team {
    //fields
    private ArrayList<Player> players,wicketPlayers;
    private String name;
    //playerIndex can be used to get players iteratively
    private int score,wickets,playerIndex;
    public Team(ArrayList<Player> players,String name)
    {
        this.players = players;
        this.name = name;
        this.playerIndex = -1; 
        this.wicketPlayers = new ArrayList<>();
        this.wickets = 0;
    }
    
    public Team(String name)
    {
        this.name = name;
        this.playerIndex = -1; 
        this.wicketPlayers = new ArrayList<>();
        this.players = new ArrayList<>();
        this.wickets = 0;
    }
    //getter setter
    public String getName() {
        return name;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public int getScore() {
        return score;
    }
    public int getWickets() {
        return wickets;
    }
    public Player getCaptain()
    {
        Player cap = players.get(0);
        for (Player player : players)
            if(player.isCaptain())
                cap = player;
        return cap;
    }
        //invoke hasNext brfore using this
    public Player getPlayer() {

        return players.get(++playerIndex);
    }
    public int getPlayerIndex() {
        return playerIndex;
    }
    public void addWickets(Player player) {
        player.addWicket();
        this.wickets += 1;
    }
    public int addScore(Player player,int score)
    {
        //player . add score will return new score;
        this.score += score;
        player.addScore(score);
        return getScore();
    }
    public void addPlayer(String playerName,int playerRole,boolean isCaptain)
    {
        players.add(new Player(playerName,playerRole,isCaptain));
    }
    public void addPlayer(ArrayList<Player> players)
    {
        this.players = players;
    }
    //methods
    public void playerOut(Player player)
    {
        player.batsmanOut();
        wicketPlayers.add(player);
    }
    public boolean hasNext() {
        return playerIndex < players.size()-1;
    }
    public void resetPlayerIndex() {
        this.playerIndex = 0;
    }
    public void sortBatsmenFirst() {
        Collections.sort(players,new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                if(a.getRole() == b.getRole())
                    return 0;
                else if(a.getRole() > b.getRole())
                    return 1;
                else return -1;
            }
        });
        System.out.println(players);
    }

    public void sortBowlersFirst() {
        Collections.sort(players,new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                if(a.getRole() == b.getRole())
                    return 0;
                else if(a.getRole() > b.getRole())
                    return -1;
                else return 1;
            }
        });
        System.out.println(players);
    }
    public String shortInfo() {
        
        return "TEAM :"+getName()+"\\nScore :"+getScore();
    }
    public String toString(){
        String str="";
        str += ("\nTeam :"+ this.getName()+" "+getScore()+" run(s)");
        str+=("\nPlayers list");
        for (Player player : this.getPlayers())
            str+="\n"+(player.isCaptain()?"--CAPTAIN--":"-----------")+(player.toString());
        return str;
    }

    
}
