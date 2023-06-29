package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private long studentNumber;
    private List<Integer> grades;

    public Student(String name, int age, long studentNumber) {
        super(name, age);
        this.studentNumber = studentNumber;
        this.grades = new ArrayList<>();
    }

    @Override
    public void printName() {
        super.printName();
        System.out.println("Student number is: "+this.studentNumber);
    }
}
