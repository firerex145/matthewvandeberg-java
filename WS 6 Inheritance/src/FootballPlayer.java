public class FootballPlayer extends Player{
    private int myGamesPlayed;
    private int myPoints;

    public FootballPlayer(String team, String name, int number, int gamesPlayed, int points) {
        super(team, name, number);
        myGamesPlayed = gamesPlayed;
        myPoints = points;
    }

    public int getGamesPlayed() {
        return myGamesPlayed;
    }

    public int getPoints() {
        return myPoints;
    }
}
