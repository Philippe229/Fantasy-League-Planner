package conuhacks3.fantasyleagueplanner;

public class Player {
//    var names must match exactly json response for wrapper
    public enum PositionCodes {Center, LeftWing, RightWing}
    private PositionCodes PositionCode;
    private String FirstName;
    private String LastName;
    private int SkatingGoalsTotal;
    private int SkatingAssistsTotal;
    private int score;
    private PoolConfiguration config;

    public Player(String FirstName, String LastName, int SkatingGoalsTotal, int SkatingAssistsTotal, PositionCodes PositionCode){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.SkatingGoalsTotal = SkatingGoalsTotal;
        this.SkatingAssistsTotal = SkatingAssistsTotal;
        this.PositionCode = PositionCode;
    }

    protected void setScore(){
        if(this.PositionCode == PositionCode.Center || this.PositionCode == PositionCode.LeftWing || this.PositionCode == PositionCode.RightWing)
            this.score = SkatingGoalsTotal*config.getAttackerGoals() + SkatingAssistsTotal*config.getAttackerAssists();
        else
            this.score = SkatingGoalsTotal*config.getDefenderGoals() + SkatingAssistsTotal*config.getDefenderAssists();
    }

    protected int getScore(){
        return this.score;
    }

    protected void setPoolConfiguration(PoolConfiguration config){
        this.config = config;
    }

}
