public class Client {
    public static void main(String[] args) {
        ProjectManager matt = new ProjectManager();
        Engineer gavin = new Engineer();
        SeniorEngineer eric = new SeniorEngineer();
        Janitor phil = new Janitor();

        System.out.println("Project Manager");
        matt.trackStatus();
        System.out.println("Hours: " + matt.getHours());
        System.out.println("Salary: " + matt.getSalary());
        System.out.println("Vacation Days: " + matt.getVacationDays());
        System.out.println("Vacation Form: " + matt.getVacationForm());

        System.out.println();

        System.out.println("Engineer");
        gavin.testCode();
        System.out.println("Hours: " + gavin.getHours());
        System.out.println("Salary: " + gavin.getSalary());
        System.out.println("Vacation Days: " + gavin.getVacationDays());
        System.out.println("Vacation Form: " + gavin.getVacationForm());

        System.out.println();

        System.out.println("Senior Engineer");
        eric.herdCats();
        System.out.println("Hours: " + eric.getHours());
        System.out.println("Salary: " + eric.getSalary());
        System.out.println("Vacation Days: " + eric.getVacationDays());
        System.out.println("Vacation Form: " + eric.getVacationForm());

        System.out.println();

        System.out.println("Janitor");
        phil.hardWork();
        System.out.println("Hours: " + phil.getHours());
        System.out.println("Salary: " + phil.getSalary());
        System.out.println("Vacation Days: " + phil.getVacationDays());
        System.out.println("Vacation Form: " + phil.getVacationForm());
    }
}
