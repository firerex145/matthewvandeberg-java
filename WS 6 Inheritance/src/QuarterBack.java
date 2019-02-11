public class QuarterBack extends FootballPlayer {
    private int myPassingYards;

    public QuarterBack(String team, String name, int number, int gamesPlayed, int points, int passingYards) {
        super(team, name, number, gamesPlayed, points);
        myPassingYards = passingYards;
    }

    public int getPassingYards() {
        return myPassingYards;
    }

    public String toString() {
        return "I throw the football";
    }

    public String passingYardsPerGame() {
        return "Passing yards per game: " + myPassingYards / getGamesPlayed() + " yards";
    }

    public String pointsPerGame() {
        return "Points per game: " + getPoints() / getGamesPlayed() + " points";
    }
}
