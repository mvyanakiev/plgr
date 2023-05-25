package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainStream {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Pesho", 23));
        students.add(new Student("Gosho", 45));
        students.add(new Student("Gosho", 19));
        students.add(new Student("Ani", 22));

        // Намираме в листа ако го има
        Optional<Student> imaPesho = students.stream().filter(s -> s.getName().equals("Pesho")).findFirst();
        Optional<Student> niamaIvan = students.stream().filter(s -> s.getName().equals("Ivan")).findFirst();

        List<Student> vsichkiGosho = students.stream().filter(s -> s.getName().equals("Gosho")).collect(Collectors.toList());

        System.out.println("debug");

        //Премахване от листа
        students.removeIf(s -> "Ani".equals(s.getName()));

        System.out.println("debug");
    }
}

