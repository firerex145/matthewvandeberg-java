public class Receiver extends FootballPlayer {
    private int myReceivingYards;

    public Receiver(String team, String name, int number, int gamesPlayed, int points, int receivingYards) {
        super(team, name, number, gamesPlayed, points);
        myReceivingYards = receivingYards;
    }

    public int getReceivingYards() {
        return myReceivingYards;
    }

    public String toString() {
        return "I catch the football";
    }

    public String receivingYardsPerGame() {
        return "Receiving yards per game: " + myReceivingYards / getGamesPlayed() + " yards";
    }

    public String pointsPerGame() {
        return "Points per game: " + getPoints() / getGamesPlayed() + " points";
    }
}
