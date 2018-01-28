package conuhacks3.fantasyleagueplanner;
import java.util.Comparator;

public class SortByScore implements Comparator<Player>{
    //Comparator used to sort players by score
    public int compare(Player a, Player b){
        return a.getScore() - b.getScore();
    }
}
