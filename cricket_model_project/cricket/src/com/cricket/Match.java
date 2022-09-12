package com.cricket;

//optimize init methods
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Match {
    // constants
    public static int MAX_PLAYERS = 11;
    public static int TEAM_A = 0;
    public static int TEAM_B = 1;
    public static int HEAD = 0;
    public static int TAIL = 1;
    private static final int BAT = 0;
    private static final int BOWL = 1;
    // fields
    int balls, maxOvers;
    Team teamA, teamB, bowling, batting, teamWonToss, teamLoseToss;
    Player bowler, batsman, nonStrike;
    Scanner scanner;

    public Match(int maxOvers) {
        
        scanner = new Scanner(System.in);
        this.maxOvers = maxOvers;
        this.balls = 0;
        // get input if user wants autoInit
        System.out.println("Enter 0 to manually initialize player details");
        System.out.println("Enter 1 to automatically initialize details");
        System.out.print("input >");
        if (Integer.parseInt(scanner.nextLine()) == 1) {
            initTeamsWithDb();
        } else {
            initTeamsManually();
        }
    }

    public Match(int maxOvers, boolean autoInit) {
        scanner = new Scanner(System.in);
        this.maxOvers = maxOvers;
        this.balls = 0;
        // init the teams
        if (autoInit)
            initTeamsWithDb();
        else// remove teamaNmae here###
            initTeamsManually();

    }

    private void initTeamsWithDb() {
        int teamNum = 0;
        // try init db with files
        try {
            ArrayList<String> teamsList = dbParser.getTeamsList();

            // if thers only two teams in db
            if (teamsList.size() < 2) {
                throw new NotEnoughTeams();
            } else if (teamsList.size() == 2) {
                System.out.println("\nonly two teams found in db,So adding two teams...");
                this.teamA = new Team(teamsList.get(0));
                this.teamB = new Team(teamsList.get(1));
                for (int k = 0; k < 2; k++) {
                    // can optimize
                    ArrayList<String> playersList = dbParser.getPlayerList(teamsList.get(k));
                    if (k == 0)
                        for (String player : playersList) {
                            String[] playerInfo = player.split(" ");
                            // playerInfo.length==3 will determine if he had a CAP word
                            teamA.addPlayer(playerInfo[0], Player.parseRole(playerInfo[1]), (playerInfo.length == 3));
                        }
                    else
                        for (String player : playersList) {
                            String[] playerInfo = player.split(" ");
                            teamB.addPlayer(playerInfo[0], Player.parseRole(playerInfo[1]), (playerInfo.length == 3));
                        }
                }
            } else
            // get input two times
            {
                for (int j = 0; j < 2; j++) {
                    System.out.println("\nSelect the input by entering number");
                    System.out.println("Team" + (j + 1));
                    // print the teams to console
                    for (int i = 0; i < teamsList.size(); i++)
                        System.out.println(i + "." + teamsList.get(i));
                    while (true) {
                        // get input until he give a correct input
                        System.out.print("input>");
                        teamNum = Integer.parseInt(scanner.nextLine());
                        // init team
                        if (teamNum >= 0 && teamNum <= teamsList.size() - 1) {
                            // prepare the team players array
                            String teamName = teamsList.get(teamNum);
                            ArrayList<String> playerList = dbParser.getPlayerList(teamName);
                            if (j == 0) {
                                this.teamA = new Team(teamName);
                                for (String playerName : playerList) {
                                    String[] playerInfo = playerName.split(" ");
                                    this.teamA.addPlayer(playerInfo[0], Player.parseRole(playerInfo[1]),
                                            (playerInfo.length == 3));
                                }
                            } else {
                                // if same team is given
                                if (teamA.getName().equals(teamName)) {
                                    System.out.println("[WARN] Choose different teams\n");
                                    continue;
                                }
                                // create teamB obj
                                this.teamB = new Team(teamsList.get(teamNum));
                                for (String playerName : playerList) {
                                    String[] playerInfo = playerName.split(" ");
                                    this.teamB.addPlayer(playerInfo[0], Player.parseRole(playerInfo[1]),
                                            (playerInfo.length == 3));
                                }
                            }
                            break;
                        } else
                            System.out.println("[ERR]Invalid input\n");
                    }
                }
            }

            System.out.println("[OK]Team init successful\n");
        }
        // when you fail to parse then take maunal input
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("[WARN]falling back to manual input\n");
            initTeamsManually();
        }
    }

    private void initTeamsManually() {

        // get team names
        System.out.print("\nEnter name for team 1:");
        String teamAName = (scanner.nextLine());
        System.out.print("\nEnter name for team 2:");
        String teamBName = (scanner.nextLine());
        // init team object
        teamA = new Team(teamAName);
        teamB = new Team(teamBName);
        // store team to get input for both teams
        Team team = teamA;
        for (int j = 0; j < 2; j++) {// get team names
            System.out
                    .println("\nEnter player names for " + team.getName() + " team (least 5 player should be bowlers)");
            // get player names iteratively
            for (int i = 0; i < MAX_PLAYERS; i++) {
                System.out.print("\nPlayer" + (i + 1) + " name:");
                String playerName = scanner.nextLine();
                // get role from user
                System.out.println("\nPlayer role:");
                System.out.println("0.Captain");
                System.out.println("1.Batsman");
                System.out.println("2.Allrounder");
                System.out.println("3.Spinner");
                System.out.println("4.Bowler");
                System.out.print("input>");
                int playerRole = Integer.parseInt(scanner.nextLine());
                if (playerRole >= 0 && playerRole <= 4)
                    team.addPlayer(playerName, playerRole, false);
                else {
                    System.out.println("[WARN] Wrong input, assuming the player is Batsman\n");
                    team.addPlayer(playerName, Player.BATSMAN, false);
                }
            }
            team = teamB;
        }
        System.out.println("[OK]Manual Team init successfull\n");
    }

    // getters setters for testing####
    public Team[] getTeams() {
        return new Team[] { this.teamA, this.teamB };
    }

    private int toss() {
        return new Random().nextInt(2);
    }

    // match starts here ***************
    public Result start() {
        boolean autoPlay = false;
        char choice;
        Player batsman, nonStrike, bowler;
        Result result=new Result();

        //ask for auto play
        System.out.print("Auto Play(Y/n):");
        choice =scanner.next().charAt(0);
        autoPlay = (choice=='Y'||choice == 'y')?true:false;

        //all the operations for choosing team will be done in tossEvent
        tossEvent();
        // default winner is first batting team
        result.setResult(teamWonToss, teamLoseToss);

        // two matches
        for (int mcount = 1; mcount <= 2; mcount++) {
            // sort the player list to get the apt player at top
            sortPlayers();

            // select the players
            System.out.println("[INFO]selecting players ...");
            batsman = batting.getPlayer();
            nonStrike = batting.getPlayer();
            bowler = bowling.getPlayer();
            
            printStartupDetails(batsman,nonStrike,bowler,mcount);
            // MATCH START
            while (true) {
                //to get input for score
                int score = 0;
                countBalls(); 
                BatsmanStates batsmanState = getBatsmanState(autoPlay);
                // baTSMAN scored
                if (batsmanState == BatsmanStates.RUN) {
                    score = getScore(autoPlay);
                    batting.addScore(batsman, score);
                    if (score % 2 != 0) {
                        // change batsman and non strike positions
                        System.out.println("[INFO] Batsman and Nonstrike positions Changed");
                        printCurrentPlayers(batsman, bowler, nonStrike);
                        Player temp = batsman;
                        batsman = nonStrike;
                        nonStrike = temp;
                    }
                } else if((batsmanState == BatsmanStates.BOLD) || (batsmanState == BatsmanStates.CATCH)){
                    // ifout
                    System.out.println("[OUT] "+batsman.getName()+" "+batsmanState+"("+batsman.getScore()+" runs)");
                    batting.playerOut(batsman);
                    bowling.addWickets(bowler);
                    if (batting.hasNext()) {
                        batsman = batting.getPlayer();
                        System.out.println("[INFO] New Batsman");
                        printCurrentPlayers(batsman, bowler, nonStrike);
                    } else {
                        System.out.println("[INFO] No batsmen left");
                        break;
                    }
                }
                // if(batsmanState == BatsmanStates.NOBALL || batsmanState == BatsmanStates.WIDE)
                else
                {
                    score = getScore(autoPlay)+1;
                    System.out.println("["+batsmanState+"] so score +1 = "+score);
                    batting.addScore(batsman, score);
                    reBall();
                    
                }
                // bowlers over check and swap strike non strike
                if (getBalls() % (6) == 0) {
                    // bowler change
                    if (bowling.hasNext()) {
                        System.out.println("[INFO] Bowler changed");
                        bowler = bowling.getPlayer();
                        printCurrentPlayers(batsman, bowler, nonStrike);
                    } else {
                        // no bowlers
                        bowling.resetPlayerIndex();
                    }
                    // change batsman and non strike positions
                    System.out.println("[INFO] Batsman and Nonstrike positions Changed");
                    printCurrentPlayers(batsman, bowler, nonStrike);
                    Player temp = batsman;
                    batsman = nonStrike;
                    nonStrike = temp;

                }

                // check for win()
                if (mcount == 2 && batting.getScore() > bowling.getScore()) {
                    result.setResult(batting,bowling);
                    break;
                }
                // over all over check
                else if (balls == (maxOvers * 6)) {
                    // if(match is draw)
                    if (batting.getScore() == bowling.getScore())
                        result.setDraw(true);
                    else if(batting.getScore() <bowling.getScore())
                        result.setResult(bowling, batting);
                    break;
                }
                // delay for auto input
                if (autoPlay) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("[NEXT] 2nd innnings : Batting Bowlling Teams change");
            Team temp = batting;
            batting = bowling;
            bowling = temp;
            batting.resetPlayerIndex();
            bowling.resetPlayerIndex();
            resetBalls();
        }
        // MATCH END
        scanner.close();
        return result;
    }

    private void reBall() {
        this.balls--;
    }

    private int getBalls() {
        return this.balls;
    }

    private void countBalls() {
        this.balls++;
    }

    private void resetBalls() {
        this.balls = 0;
    }

    private int getScore(boolean autoPlay) {
        return autoPlay ? getRandScore() : getUserInputScore();
    }

    private BatsmanStates getBatsmanState(boolean autoPlay) {
        
        return (autoPlay) ? getRandState() : getUserInputState();
    }

    private int getUserInputScore() {
        // manual input
        System.out.println("\nEnter the score\ninput>");
        return (scanner.nextInt());
    }

    private BatsmanStates getUserInputState() {
        
        // manual input
        int i=0;
        System.out.println("\nBatsman state");
        for (BatsmanStates state : BatsmanStates.values()) {
            System.out.println(i+"."+state);
            i++;
        }
        System.out.println("input>");
        i = (scanner.nextInt());
        return  (i>=4&&i<=0)? BatsmanStates.values()[i] : BatsmanStates.values()[0];
    }

    private int getRandScore() {
        // auto input
        int score = new Random().nextInt(7);
        System.out.println("score : " + score);
        return score;
    }

    private BatsmanStates getRandState() {
        // auto input
        int stateIndex = new Random().nextInt(5);
        System.out.println("batsman state:" + BatsmanStates.values()[stateIndex]);
        return BatsmanStates.values()[stateIndex];
    }

    private void tossEvent() {
        Team teamWillToss;
        int headOrTail, batOrBowl;
        System.out.println("--TOSS--");
        // ask who wants to choose side in toss
        System.out.println("Choose a team to continue toss");// alter word#####
        teamWillToss = chooseTeam();
        // choose head or tail
        headOrTail = chooseHeadOrTail(teamWillToss.getName());
        // toss
        // if the team selected to toss won the toss
        if (toss() == headOrTail) {
            teamWonToss = teamWillToss;
            teamLoseToss = (teamWonToss.equals(teamA) ? teamB : teamA);
            // print head or tail
            System.out.println("\n[TOSS] " + ((headOrTail == HEAD) ? "Head" : "Tail"));
        } else {
            if (teamWillToss.equals(teamA)) {
                teamWonToss = teamB;
                teamLoseToss = teamA;
            } else {
                teamWonToss = teamA;
                teamLoseToss = teamB;
            }
            // print head or tail
            System.out.println("\n[TOSS] " + ((headOrTail == HEAD) ? "Tail" : "Head"));
        }
        // print toss result
        System.out.println("[TOSS] " + teamWonToss.getName() + " won the toss");
        // choose bat or bowl
        batOrBowl = chooseBatOrBowl(teamWonToss.getName());
        setBatBowlTeams(teamWonToss, teamLoseToss, batOrBowl);
        
    }

    private void sortPlayers() {
        batting.sortBatsmenFirst();
        bowling.sortBowlersFirst();
    }

    private void printStartupDetails(Player batsman,Player bowler,Player nonStrike,int matchNo) {
        System.out.println("\nmatch no :" + matchNo);
        System.out.println("BATTING - " + batting.getName());
        System.out.println(batting+"\n");
        System.out.println("BOWLING - " + bowling.getName());
        System.out.println(bowling+"\n");
        System.out.println("-------------------");
        System.out.println("now..");
        printCurrentPlayers(batsman, bowler, nonStrike);

    }

    private void printCurrentPlayers(Player batsman,Player bowler,Player nonStrike)
    {
        System.out.println("Batsman:" + batsman.getName());
        System.out.println("NonStrike: " + nonStrike.getName());
        System.out.println("Bowler:" + bowler.getName());
        System.out.println();
    }
    private void setBatBowlTeams(Team teamWonToss, Team teamLoseToss, int batOrBowl) {
        if (batOrBowl == BAT) {
            this.batting = teamWonToss;
            this.bowling = teamLoseToss;
        } else {
            this.bowling = teamWonToss;
            this.batting = teamLoseToss;
        }
    }

    private int chooseHeadOrTail(String teamName) {
        int choice = HEAD;
        System.out.println("\nTeam " + teamName + " Choose head or tail");// alter word#####
        System.out.println("0.Head\n1.Tail\ninput>");
        choice = (scanner.nextInt() >= TAIL) ? TAIL : HEAD;
        return choice;
    }

    private Team chooseTeam() {
        Team choice;
        System.out.print("\n0." + teamA.getName() + "\n1." + teamB.getName() + "\ninput>");
        choice = scanner.nextInt() <= 0 ? teamA : teamB;
        return choice;
    }

    private int chooseBatOrBowl(String teamName) {
        int choice;
        System.out.println("\nTEAM " + teamName + " Choose Bat or bowl");// alter word#####
        System.out.println("0.Bat\n1.Bowl\ninput>");
        choice = (scanner.nextInt() >= TAIL) ? BOWL : BAT;

        return choice;
    }

    @Override
    public String toString() {
        String str = "\n" + this.teamA.getName() + " Team\n";
        str += teamA + "\n";
        str += "\n" + this.teamB.getName() + " Team\n";
        str += teamB + "\n";
        return str;
    }
}

enum BatsmanStates
{
    RUN,NOBALL,WIDE,CATCH,BOLD;
};