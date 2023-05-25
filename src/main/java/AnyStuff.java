import stream.Student;

import java.util.HashMap;
import java.util.Map;

public class AnyStuff {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        String timeToString = String.valueOf(System.currentTimeMillis()).substring(8, 12);
        double randomDouble = Double.parseDouble(timeToString.substring(0, 2) + "." + timeToString.substring(2, 4));

        System.out.println(timeToString);
        System.out.println(randomDouble);

        Map<String, Student> studentHashMap = new HashMap<>();

        studentHashMap.put("A", new Student("A", 22));
        studentHashMap.put("B", new Student("B", 22));
        studentHashMap.put("C", new Student("C", 22));

        Student student = studentHashMap.get("A");
        student.setAge(100);
        student.setName("Ani");

        studentHashMap.put("A", student);

        System.out.println("debug");

        studentHashMap.replace("A", student);

        System.out.println("debug");
    }
}
