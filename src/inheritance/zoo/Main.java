package inheritance.zoo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();


        Bear bear = new Bear("Bear");
        Gorilla gorilla = new Gorilla("Gorilla");
        Snake snake = new Snake("Snake");
        printAnimal(snake);
    }


    private static void printAnimal(Animal animal) {
        System.out.println(animal.getName());
    }
}
