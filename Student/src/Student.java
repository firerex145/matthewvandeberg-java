import java.util.ArrayList;

public class Student {
    private String studentName;
    private String studentGrade;

    private ArrayList<Double> grades = new ArrayList<>();

    public Student(String studentName, String studentGrade) {
        this.studentName = studentName;
        this.studentGrade = studentGrade;
    }

    public String passingOrFailing() {
        double sum = 0;

        for (double i : grades) {
            sum += i;
        }

        if ((sum / grades.size()) * 100 > 65) {
            return "passing";
        } else {
            return "failing";
        }
    }

    public int numOfClasses() {
        return grades.size();
    }

    public String nameOfStudent() {
        return studentName;
    }

    public String gradeOfStudent() {
        return studentGrade;
    }

    public void addGrade(double newGrade) {
        grades.add(newGrade);
    }

    public String toString() {
        return studentName + " is a " + studentGrade;
    }
}
