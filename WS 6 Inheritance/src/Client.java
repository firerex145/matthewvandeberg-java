public class Client {
    public static void main(String[] args) {
        QuarterBack wilson = new QuarterBack("Seahawks", "Wilson", 9, 12, 250, 1500);
        Receiver baldwin = new Receiver("Seahawks", "Baldwin", 89, 16, 300, 2000);
        RunningBack lynch = new RunningBack("Seahawks", "Lynch", 24, 15, 150, 2200);

        System.out.println();
        System.out.println(wilson.toString());
        System.out.println(wilson.passingYardsPerGame());
        System.out.println(wilson.pointsPerGame());
        System.out.println();

        System.out.println(baldwin.toString());
        System.out.println(baldwin.receivingYardsPerGame());
        System.out.println(baldwin.pointsPerGame());
        System.out.println();

        System.out.println(lynch.toString());
        System.out.println(lynch.runningYardsPerGame());
        System.out.println(lynch.pointsPerGame());
        System.out.println();
    }
}
