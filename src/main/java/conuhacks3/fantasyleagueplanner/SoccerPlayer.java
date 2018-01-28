package conuhacks3.fantasyleagueplanner;

public class SoccerPlayer{
    // var names must match exactly json response for wrapper, case sensitive
    public enum PositionCodes {f, m, d, gk}
    private PositionCodes PositionCode;
    private String FirstName;
    private String LastName;
    private Statistics Statistics;
    private int score;
    private PoolConfigurationSoccer config;

    public SoccerPlayer(String FirstName, String LastName, Statistics StatisticDetails, PositionCodes PositionCode){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Statistics = StatisticDetails;
        this.PositionCode = PositionCode;
    }

    protected void setScore(){
        if(this.PositionCode == PositionCodes.f)
            this.score = Statistics.getGoals()*config.getAttackerGoals() +
                    Statistics.getAssists()*config.getAttackerAssists();
        else if(this.PositionCode == PositionCodes.m)
            this.score = Statistics.getGoals()*config.getMidfielderGoals() +
                    Statistics.getAssists()*config.getMidfielderAssists();
        else
            this.score = Statistics.getGoals()*config.getDefenderGoals() +
                    Statistics.getAssists()*config.getDefenderAssists();
    }

    protected int getScore(){
        return this.score;
    }

    protected void setPoolConfiguration(PoolConfigurationSoccer config){
        this.config = config;
    }

    public String getFullName() {
        return FirstName + " " + LastName;
    }

    public String toString(){
        return this.FirstName + " " + this.LastName + ": " + this.Statistics.toString() + ", PositionCode: " +
                this.PositionCode + ", score: " + this.score;
    }

    // nested class corresponding to nested json object
    public static class Statistics {
        // var names must match exactly json response for wrapper
        protected int Goals;
        protected int Assists;

        public Statistics(int Goals, int Assists){
            this.Goals = Goals;
            this.Assists = Assists;
        }

        public String toString(){
            return "goals: " + Goals + ", assists: " + Assists;
        }

        public int getGoals(){
            return Goals;
        }

        public int getAssists(){
            return Assists;
        }
    }
}
