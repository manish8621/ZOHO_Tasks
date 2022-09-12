package com.cricket;
public class Player {
    //constants
    public static final int BATSMAN = 1;
    public static final int ALLROUNDER = 2;
    public static final int SPINNER = 3;
    public static final int BOWLER = 4;
    //fields
    private boolean isCaptain,out;
    private String name;
    private int score,wicketsScored,role;
    //constructor
    public Player(String name,int role,boolean isCaptain)
    {
        this.name = name;
        this.role = role;
        this.isCaptain = isCaptain;
        this.out = false;
        this.wicketsScored = 0;
    }
    public int getRole() {
        return role;
    }
    public boolean isOut() {
        return out;
    }
    public void batsmanOut()
    {
        this.out = true;
    }
    public String getName() {
        return name;
    }
    public int addScore(int score) {
        this.score += score;
        return getScore();
    }
    public int getScore() {
        return score;
    }
    public int getWicket() {
        return wicketsScored;
    }
    public boolean isCaptain() {
        return isCaptain;
    }
    public String getRoleName() {
        switch (getRole()) {
            case BATSMAN:
                return "BATSMAN";
            case ALLROUNDER:
                return "ALLROUNDER";
            case SPINNER:
                return "SPINNER";
            case BOWLER:
                return "BOWLER";
            default:
                return "-";
        }
    }
    public void addWicket() {
        this.wicketsScored += 1;
    }
    public static int parseRole(String role) {
        switch (role) {
            case "BATSMAN":
                return BATSMAN;
            case "ALLROUNDER":
                return ALLROUNDER;
            case "SPINNER":
                return SPINNER;
            case "BOWLER":
                return BOWLER;
            default:
                return BATSMAN;
        }
    }
    public void padString(String s) {
        
    }
    @Override
    public String toString() {
        
        String str = String.format("|%-8s|%-4s|%-20s|%-6s|%-8s|",(isCaptain()?"yes":""),(isOut()?"out":""),getName(), getScore(),getWicket());
        // str+="----------------------------------------------------";
        return str;
    }
}
