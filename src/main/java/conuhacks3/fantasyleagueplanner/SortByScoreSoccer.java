package conuhacks3.fantasyleagueplanner;
import java.util.Comparator;

public class SortByScoreSoccer implements Comparator<SoccerPlayer> {
    //Comparator used to sort players by score in DESCENDING order
    public int compare(SoccerPlayer a, SoccerPlayer b){
        return b.getScore() - a.getScore();
    }
}

