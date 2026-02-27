import java.util.ArrayList;

public class FCAISystem {

    static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        AdminService.studentsList(students);
        while (true) {

            System.out.println("============== Login ==============");
            System.out.print("ID: ");
            String id = scanner.next();

            System.out.print("Password: ");
            String pass = scanner.next();

            if (id.equals("20240000") && pass.equals("2024")) {

                System.out.println("Admin Login ✔");
                boolean logout = AdminService.Start(students, doctors);
                if (!logout)
                    break;
            }
            else {

                Student current = null;

                for (Student s : students) {
                    if (s.ID.equals(id) && s.Password.equals(pass)) {
                        current = s;
                        break;
                    }
                }

                if (current != null) {
                    System.out.println("Student Login ✔");
                    boolean logout = StudentService.Start(current);
                    if (!logout)
                        break;
                }
                else {
                    System.out.println("Wrong ID or Password ❌");
                }
            }
        }

        System.out.println("System Closed.");
        scanner.close();
    }
}