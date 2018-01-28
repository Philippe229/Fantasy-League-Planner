package conuhacks3.fantasyleagueplanner;

public class Player {
    // var names must match exactly json response for wrapper, case sensitive
    public enum PositionCodes {Center, LeftWing, RightWing}
    private PositionCodes PositionCode;
    private String FirstName;
    private String LastName;
    private StatisticDetails StatisticDetails;
    private int score;
    private PoolConfiguration config;

    public Player(String FirstName, String LastName, StatisticDetails StatisticDetails, PositionCodes PositionCode){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.StatisticDetails = StatisticDetails;
        this.PositionCode = PositionCode;
    }

    protected void setScore(){
        if(this.PositionCode == PositionCode.Center || this.PositionCode == PositionCode.LeftWing || this.PositionCode == PositionCode.RightWing)
            this.score = StatisticDetails.getGoals()*config.getAttackerGoals() + StatisticDetails.getAssists()*config.getAttackerAssists();
        else
            this.score = StatisticDetails.getGoals()*config.getDefenderGoals() + StatisticDetails.getAssists()*config.getDefenderAssists();
    }

    protected int getScore(){
        return this.score;
    }

    protected void setPoolConfiguration(PoolConfiguration config){
        this.config = config;
    }

    public String getFullName() {
        return FirstName + " " + LastName;
    }

    public String toString(){
        return this.FirstName + " " + this.LastName + ": " + this.StatisticDetails.toString() + ", PositionCode: " + this.PositionCode + ", score: " + this.score;
    }

    // nested class corresponding to nested json object
    public static class StatisticDetails {
        // var names must match exactly json response for wrapper
        private int SkatingGoalsTotal;
        private int SkatingAssistsTotal;

        public StatisticDetails(int SkatingGoalsTotal, int SkatingAssistsTotal){
            this.SkatingGoalsTotal = SkatingGoalsTotal;
            this.SkatingAssistsTotal = SkatingAssistsTotal;
        }

        public String toString(){
            return "goals: " + SkatingGoalsTotal + ", assists: " + SkatingAssistsTotal;
        }

        public int getGoals(){
            return SkatingGoalsTotal;
        }

        public int getAssists(){
            return SkatingAssistsTotal;
        }
    }

}
