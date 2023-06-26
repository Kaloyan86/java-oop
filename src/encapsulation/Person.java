package encapsulation;

import working_with_abstractions.greedyTimes.Item;
import working_with_abstractions.greedyTimes.ItemType;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 0) {
            System.out.println("Age can't be negative");
        } else {
            this.age = age;
        }


    }
}
