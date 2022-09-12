package com.cricket;

public class NotEnoughTeams extends Exception {
    NotEnoughTeams()
    {
        super("Not enough teams in Db .");
    }
}
