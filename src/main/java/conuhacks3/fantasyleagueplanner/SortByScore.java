package conuhacks3.fantasyleagueplanner;
import java.util.Comparator;

public class SortByScore implements Comparator<Player>{
    //Comparator used to sort players by score in DESCENDING order
    public int compare(Player a, Player b){
        return b.getScore() - a.getScore();
    }
}
