package inheritance;

public class Demo {
    /*
                 ----- Inheritance ------

       One of the 4 OOP principles ( Abstraction, Encapsulation, Inheritance, Polymorphism )

       Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object.

       Inheritance represents the IS-A relationship which is also known as a parent-child relationship.

       When you inherit from an existing class, you can reuse methods and fields of the parent class.
       Moreover, you can add new methods and fields in your current class also.

       To inherit from a class, use the extends keyword.
       - subclass (child) - the class that inherits from another class
       - superclass (parent) - the class being inherited from

       ----- Inheritance - Benefits -----
       - For Method Overriding (so runtime polymorphism can be achieved).
       - For Code Reusability.

       * Multiple Inheritance is not allowed in Java

     */

    public static void main(String[] args) {
        Student student = new Student("Kaloyan", 37, 123);

        student.printName();
    }


}
