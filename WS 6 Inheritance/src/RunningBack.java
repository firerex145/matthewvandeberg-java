public class RunningBack extends FootballPlayer{
    private int myRunningYards;

    public RunningBack(String team, String name, int number, int gamesPlayed, int points, int runningYards) {
        super(team, name, number, gamesPlayed, points);
        myRunningYards = runningYards;
    }

    public int getRunningYards() {
        return myRunningYards;
    }

    public String toString() {
        return "I run the football";
    }

    public String runningYardsPerGame() {
        return "Running yards per game: " + myRunningYards / getGamesPlayed() + " yards";
    }

    public String pointsPerGame() {
        return "Points per game: " + getPoints() / getGamesPlayed() + " points";
    }
}
