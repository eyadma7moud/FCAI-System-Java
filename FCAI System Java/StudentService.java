import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentService {

    static Scanner scanner = new Scanner(System.in);

    public static void displayInfo(Student student) {
        System.out.println("Name: " + student.Name);
        System.out.println("ID: " + student.ID);
        System.out.println("GPA: " + student.GPA);
        System.out.println("Phone: " + student.Phone);
    }

    public static void RegisteredCourses(Student student) {
        if (student.RegisteredCourses.isEmpty()) {
            System.out.println("No Registered Courses");
            return;
        }

        for (int i = 0; i < student.RegisteredCourses.size(); i++)
            System.out.println("[" + (i + 1) + "] " + student.RegisteredCourses.get(i));
    }

    public static void RegisterNewCourse(Student student) {

        ArrayList<String> courses = new ArrayList<>(Arrays.asList(
                "Data Structure",
                "Network",
                "Logic Design",
                "Math-3",
                "OOP",
                "Database",
                "Software Engineering",
                "Management",
                "Social Issues"
        ));

        for (int i = 0; i < courses.size(); i++)
            System.out.println("[" + (i + 1) + "] " + courses.get(i));

        System.out.print("Choose Course: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > courses.size()) {
            System.out.println("Invalid Choice ❌");
            return;
        }

        String selected = courses.get(choice - 1);

        if (student.RegisteredCourses.contains(selected)) {
            System.out.println("Already Registered ❌");
            return;
        }

        student.RegisteredCourses.add(selected);
        System.out.println("Course Added ✔");
    }

    public static void DeleteCourse(Student student) {

        RegisteredCourses(student);
        if (student.RegisteredCourses.isEmpty())
            return;

        System.out.print("Choose Course Number: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > student.RegisteredCourses.size()) {
            System.out.println("Invalid Choice ❌");
            return;
        }

        student.RegisteredCourses.remove(choice - 1);
        System.out.println("Deleted ✔");
    }

    public static boolean Start(Student student) {

        while (true) {

            System.out.println("============= Student Menu =============");
            System.out.println("[1] Student Info");
            System.out.println("[2] Registered Courses");
            System.out.println("[3] Register Course");
            System.out.println("[4] Delete Course");
            System.out.println("[5] Logout");
            System.out.println("[6] Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: displayInfo(student); break;
                case 2: RegisteredCourses(student); break;
                case 3: RegisterNewCourse(student); break;
                case 4: DeleteCourse(student); break;
                case 5: return true;
                case 6: return false;
                default: System.out.println("Invalid ❌");
            }

            System.out.println("\nPress Enter...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }
}