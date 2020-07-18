import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Match {
    private String hostTeamName;
    private String guestsTeamName;
    private int goalHostTeam;
    private int goalGuestsTeam;

    public Match(String hostTeamName, String guestsTeamName, int goalHostTeam, int goalGuestsTeam) {
        this.hostTeamName = hostTeamName;
        this.guestsTeamName = guestsTeamName;
        this.goalHostTeam = goalHostTeam;
        this.goalGuestsTeam = goalGuestsTeam;
    }

    public String getHostTeamName() {
        return hostTeamName;
    }

    public int goalDifference(){
        return goalHostTeam - goalGuestsTeam;
    }

    public void setHostTeamName(String hostTeamName) {
        this.hostTeamName = hostTeamName;
    }

    public String getGuestsTeamName() {
        return guestsTeamName;
    }

    public void setGuestsTeamName(String guestsTeamName) {
        this.guestsTeamName = guestsTeamName;
    }

    public int getGoalHostTeam() {
        return goalHostTeam;
    }

    public void setGoalHostTeam(int goalHostTeam) {
        this.goalHostTeam = goalHostTeam;
    }

    public int getGoalGuestsTeam() {
        return goalGuestsTeam;
    }

    public void setGoalGuestsTeam(int goalGuestsTeam) {
        this.goalGuestsTeam = goalGuestsTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Match)) return false;
        Match match = (Match) o;
        return goalHostTeam == match.goalHostTeam &&
                goalGuestsTeam == match.goalGuestsTeam &&
                Objects.equals(hostTeamName, match.hostTeamName) &&
                Objects.equals(guestsTeamName, match.guestsTeamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostTeamName, guestsTeamName, goalHostTeam, goalGuestsTeam);
    }

    @Override
    public String toString() {
        return hostTeamName + " - " + guestsTeamName +"("+ goalHostTeam + ":" + goalGuestsTeam + ")";
    }
}
