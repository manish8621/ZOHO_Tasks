
import com.cricket.*;

public class App {
    public static void main(String[] args) throws Exception {

        boolean autoInit = true;
        Match match = new Match(2);
        Team[] teams = match.getTeams();
        Team winner = match.start(autoInit);
        if (winner != null) {
            System.out.println("***************************");
            System.out.println("[WIN]:" + winner.getName());
            System.out.println("***************************");
            System.out.println(winner);
        } else {
            System.out.println("[DRAW]");
            System.out.println(teams[0]);
            System.out.println(teams[1]);
        }

    }

}
