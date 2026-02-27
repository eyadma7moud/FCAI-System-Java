import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdminService {

    static Scanner scanner = new Scanner(System.in);

    public static void AdminMenu() {
        System.out.println("============= Admin Menu =============");
        System.out.println("[1] Add Student");
        System.out.println("[2] Delete Student");
        System.out.println("[3] Show Students");
        System.out.println("[4] Add Doctor");
        System.out.println("[5] Delete Doctor");
        System.out.println("[6] Show Doctors");
        System.out.println("[7] Logout");
        System.out.println("[8] Exit");
    }

    //? ================= ADD STUDENT =================
    public static void addStudent(ArrayList<Student> students,
                                  String Name, String ID, String Password,
                                  String Phone, float GPA,
                                  ArrayList<String> Courses) {

        Student s = new Student();
        s.Name = Name;
        s.ID = ID;
        s.Password = Password;
        s.Phone = Phone;
        s.GPA = GPA;
        s.RegisteredCourses = Courses;

        students.add(s);
    }

    //? ================= ADD STUDENT  =================
    public static void addStudent(ArrayList<Student> students,
                                  String Name, String ID, String Password,
                                  String Phone, float GPA) {

        addStudent(students, Name, ID, Password,
                   Phone, GPA, new ArrayList<>());
    }

    //? =================  STUDENTS  =================
    public static void studentsList(ArrayList<Student> students) {

        if (!students.isEmpty())
            return; // علشان ميكررهمش

        addStudent(students, "Eyad Mahmoud Ali", "20240100", "1252",
                "01141150485", 2.33f,
                new ArrayList<>(Arrays.asList("Network", "Database")));

        addStudent(students, "Mohammed Ahmad Ali", "20240120", "1002",
                "0102156485", 2.73f,
                new ArrayList<>(Arrays.asList("Network", "Data Structure")));
    }

    //? ================= ADMIN ADD STUDENT =================
    public static void AdminAddStudent(ArrayList<Student> students) {

        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("ID: ");
        String id = scanner.next();

        System.out.print("Password: ");
        String pass = scanner.next();

        System.out.print("Phone: ");
        String phone = scanner.next();

        System.out.print("GPA: ");
        float gpa = scanner.nextFloat();

        addStudent(students, name, id, pass, phone, gpa);

        System.out.println("Student Added ✔");
    }

    //? ================= DELETE STUDENT =================
    public static void AdminDeleteStudent(ArrayList<Student> students) {

        System.out.print("Enter ID to delete: ");
        String id = scanner.next();

        boolean removed = students.removeIf(s -> s.ID.equals(id));

        if (removed)
            System.out.println("Student Deleted ✔");
        else
            System.out.println("Student Not Found ❌");
    }

    //? ================= SHOW STUDENTS =================
    public static void ShowStudents(ArrayList<Student> students) {

        if (students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }

        for (Student s : students) {
            System.out.println("Name: " + s.Name);
            System.out.println("ID: " + s.ID);
            System.out.println("GPA: " + s.GPA);
            System.out.println("Phone: " + s.Phone);
            System.out.println("Courses: " +
                    (s.RegisteredCourses.isEmpty()
                            ? "None"
                            : String.join(", ", s.RegisteredCourses)));
            System.out.println("----------------------------");
        }
    }

    //? ================= ADD DOCTOR =================
    public static void AdminAddDoctor(ArrayList<Doctor> doctors) {

        scanner.nextLine();

        System.out.print("Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Subject: ");
        String subject = scanner.nextLine();

        doctors.add(new Doctor(name, subject));

        System.out.println("Doctor Added ✔");
    }

    //? ================= SHOW DOCTORS =================
    public static void ShowDoctors(ArrayList<Doctor> doctors) {

        if (doctors.isEmpty()) {
            System.out.println("No Doctors Found");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println("Name: " + d.name);
            System.out.println("Subject: " + d.subject);
            System.out.println("----------------------------");
        }
    }

    //? ================= DELETE DOCTOR =================
    public static void AdminDeleteDoctor(ArrayList<Doctor> doctors) {

        ShowDoctors(doctors);
        if (doctors.isEmpty())
            return;

        scanner.nextLine();
        System.out.print("Enter Doctor Name to delete: ");
        String name = scanner.nextLine();

        boolean removed =
                doctors.removeIf(d -> d.name.equalsIgnoreCase(name));

        if (removed)
            System.out.println("Doctor Deleted ✔");
        else
            System.out.println("Doctor Not Found ❌");
    }

    public static boolean Start(ArrayList<Student> students,
                                ArrayList<Doctor> doctors) {

        while (true) {

            AdminMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: AdminAddStudent(students); break;
                case 2: AdminDeleteStudent(students); break;
                case 3: ShowStudents(students); break;
                case 4: AdminAddDoctor(doctors); break;
                case 5: AdminDeleteDoctor(doctors); break;
                case 6: ShowDoctors(doctors); break;
                case 7: return true;
                case 8: return false;
                default: System.out.println("Invalid ❌");
            }

            System.out.println("\nPress Enter...");
            scanner.nextLine();
            scanner.nextLine();
        }
    }
}