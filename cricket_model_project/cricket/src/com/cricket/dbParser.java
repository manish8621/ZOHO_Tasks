package com.cricket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class dbParser {
    /**
     * @return
     * @throws EmptyFileException
     */
    public static ArrayList<String> getTeamsList() throws EmptyFileException{
        String line,path = System.getProperty("user.dir")+"/bin/db/db.txt";
        BufferedReader br=null;
        ArrayList<String> teams=new ArrayList<>();
        try
        {
            br = new BufferedReader(new FileReader(new File(path)));
            //read team names from db.txt
            while ((line = br.readLine()) != null)
                teams.add(line);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //close the file
            try {if(br!=null) br.close();}
            catch (IOException e) {e.printStackTrace();}
        }
        if(teams.size()==0) throw new EmptyFileException(path);
        //this will return the list of strings which consist of player name and role with space separated
        return teams;
    }
    public static ArrayList<String> getPlayerList(String teamName) throws EmptyFileException{
        String line,path = System.getProperty("user.dir")+"/bin/db/"+teamName+".txt";
        BufferedReader br=null;
        ArrayList<String> players=new ArrayList<>();
        
        try
        {
            br = new BufferedReader(new FileReader(new File(path)));
            //read team names from db.txt
            while ((line = br.readLine()) != null)
                players.add(line);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //close the file
            try {if(br!=null) br.close();}
            catch (IOException e) {e.printStackTrace();}
        }
        if(players.size()==0) throw new EmptyFileException(path);
        //this will return the list of strings which consist of player name and role with space separated
        return players;
    }
}
