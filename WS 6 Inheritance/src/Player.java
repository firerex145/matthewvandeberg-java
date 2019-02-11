public class Player {
    private String myTeam;
    private String myName;
    private int myNumber;

    public Player(String team, String name, int number) {
        myTeam = team;
        myName = name;
        myNumber = number;
    }

    public String getTeam() {
        return myTeam;
    }

    public String getName() {
        return myName;
    }

    public int getNumber() {
        return myNumber;
    }
}
