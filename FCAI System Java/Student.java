import java.util.ArrayList;

public class Student {

    public String ID;
    public String Password;
    public String Name;
    public String Phone;
    public float GPA;
    public ArrayList<String> RegisteredCourses;

    public Student() {
        RegisteredCourses = new ArrayList<>();
    }
}