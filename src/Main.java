//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        manager.loadFromFile();

//        manager.addStudent("Pranshi", 95);
//        manager.addStudent("Rahul", 80);
//        manager.displayStudents();

        boolean running = true;

        while (running) {

            System.out.println("\n===== STUDENT GRADE TRACKER =====");
            System.out.println("1.  Add Student");
            System.out.println("2.  Display Students");
            System.out.println("3.  Calculate Average");
            System.out.println("4.  Highest Marks");
            System.out.println("5.  lowest Marks");
            System.out.println("6.  Search Student");
            System.out.println("7.  Update Marks");
            System.out.println("8.  Delete Student");
            System.out.println("9.  Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();

                    manager.addStudent(name, marks);
                    break;
                case 2:
                    manager.displayStudents();
                    break;
                case 3:
                    manager.calculateAverage();
                    break;
                case 4:
                    manager.highestMarks();
                    break;

                case 5:
                    manager.lowestMarks();
                    break;
                case 6:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter student name: ");
                    String searchName = sc.nextLine();
                    manager.searchStudent(searchName);
                    break;

                case 7:
                    sc.nextLine();

                    System.out.print("Enter student name: ");
                    String updateName = sc.nextLine();

                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();

                    manager.updateMarks(updateName, newMarks);
                    break;

                case 8:
                    sc.nextLine(); // consume newline

                    System.out.print("Enter student name: ");
                    String deleteName = sc.nextLine();

                    manager.deleteStudent(deleteName);
                    break;

                case 9:
                    manager.saveToFile();
                    running = false;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");

            }
        }
        sc.close();
    }
}