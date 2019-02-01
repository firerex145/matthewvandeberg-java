public class Janitor extends Employee {
    public int getHours() {
        return 60;
    }
    public int getSalary() {
        return 25000;
    }
    public int getVacationDays() {
        return 100;
    }
    public void hardWork() {
        System.out.println("Working for the man.");
    }
}