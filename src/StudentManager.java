import java.io.*;
import java.util.ArrayList;
public class StudentManager {
    private ArrayList<Student> students;
    public StudentManager() {
        students = new ArrayList<>();
    }
    public void addStudent(String name, int marks) {
        //check repeat
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student already exists.");
                return;
            }
        }
        //correct marks
        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }
        Student student = new Student(name, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void calculateAverage() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        int total = 0;

        for (Student student : students) {
            total += student.getMarks();
        }

        double average = (double) total / students.size();

        System.out.printf("Average Marks: %.2f%n", average);
    }

    public void highestMarks() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Student highest = students.get(0);

        for (Student student : students) {
            if (student.getMarks() > highest.getMarks()) {
                highest = student;
            }
        }

        System.out.println("\nHighest Scorer");
        System.out.println("Name : " + highest.getName());
        System.out.println("Marks: " + highest.getMarks());
        System.out.println("Grade: " + highest.getGrade());
    }

    public void lowestMarks() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Student lowest = students.get(0);

        for (Student student : students) {
            if (student.getMarks() < lowest.getMarks()) {
                lowest = student;
            }
        }

        System.out.println("\nLowest Scorer");
        System.out.println("Name : " + lowest.getName());
        System.out.println("Marks: " + lowest.getMarks());
        System.out.println("Grade: " + lowest.getGrade());
    }

    public void searchStudent(String name) {

        for (Student student : students) {

            if (student.getName().equalsIgnoreCase(name)) {

                System.out.println("\nStudent Found");
                System.out.println("Name : " + student.getName());
                System.out.println("Marks: " + student.getMarks());
                System.out.println("Grade: " + student.getGrade());

                return;
            }
        }

        System.out.println("Student not found.");
    }


    public void updateMarks(String name, int newMarks) {

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student already exists.");
                return;
            }
        }

        if (newMarks< 0 || newMarks > 100) {
            System.out.println("Marks must be between 0 and 100.");
            return;
        }
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                student.setMarks(newMarks);
                System.out.println("Marks updated successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void deleteStudent(String name) {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public void saveToFile() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));

            for (Student student : students) {
                writer.write(student.getName() + "," + student.getMarks());
                writer.newLine();
            }

            writer.close();
            System.out.println("Data saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }


    public void loadFromFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0];
                int marks = Integer.parseInt(data[1]);

                students.add(new Student(name, marks));
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("No previous data found.");
        }
    }


    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n----- Student List -----");

        for (Student student : students) {
            System.out.println("Name : " + student.getName());
            System.out.println("Marks: " + student.getMarks());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("------------------------");
        }
    }
}
