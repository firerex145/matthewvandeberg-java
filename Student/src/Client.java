import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = input.next();

        System.out.println("What grade are you in?");
        String grade = input.next();

        Student student = new Student(name, grade);

        System.out.println("How many classes are you taking?");
        int numOfClasses = input.nextInt();

        System.out.println("What are your grades?");
        for (int i = 0; i < numOfClasses; i++) {
            student.addGrade(input.nextDouble());
        }

        System.out.print(student.toString() + " - this student is taking " + student.numOfClasses() + " classes and is " + student.passingOrFailing());
    }
}
