
import com.cricket.*;

public class App {
    public static void main(String[] args) throws Exception {
        Match match = new Match(1);
        Team[] teams = match.getTeams();
        System.out.println(teams[0]);
        Result result = match.start();
        if (result.matchDraw()) {
            System.out.println("\n[DRAW]");
            System.out.println(teams[0]);
            System.out.println(teams[1]);
        } else {
            System.out.println("\n***************************");
            System.out.println("[WIN]:" + result.getWinner().getName());
            System.out.println("***************************");
            System.out.println(result.getWinner());
            System.out.println("\n***************************");
            System.out.println("[LOSE]:" + result.getLoser().getName());
            System.out.println("***************************");
            System.out.println(result.getLoser());
        }

    }

}
