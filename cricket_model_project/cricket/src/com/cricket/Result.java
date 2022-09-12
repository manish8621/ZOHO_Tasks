package com.cricket;

public class Result {
    Team winner, Loser;
    boolean draw;
    Result(){
        this.draw=false;
    }
    public Team getWinner() {
        if (draw) return null;
        return winner;
    }
    public boolean matchDraw() {
        return this.draw;
    }
    public void setDraw(boolean draw) {
        this.draw = draw;
    }
    public Team getLoser() {
        if (draw) return null;
        return Loser;
    }
    public void setResult(Team winner,Team loser) {
        this.winner = winner;
        this.Loser = loser;
    }
}
