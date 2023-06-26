package encapsulation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Kaloyan", 30);
        ArrayList list = new ArrayList<>();



        person.setAge(-25);
        System.out.println();
    }
}
