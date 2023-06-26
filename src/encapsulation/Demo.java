package encapsulation;

public class Demo {

    public final static String name = "Kaloyan";

    public static void main(String[] args) {
       /*
              ---- access modifiers ----

       private - The access level of a private modifier is only within the class. It cannot be accessed from outside the class.

       default - no keyword - If you do not specify any access level, it will be the default.
                              The access level of a default modifier is only within the package.

       protected - The access level of a protected modifier is within the package and outside the package through child class.
                   If you do not make the child class, it cannot be accessed from outside the package.

       public - It can be accessed from within the class, outside the class, within the package and outside the package.

              ---- final keyword -----

       final on Class - Class can't be extended

       final on method - Method can't be overridden

       final on variable - Variable value can't be changed once it is set

             ----- Encapsulation ------

       One of the 4 OOP principles ( Abstraction, Encapsulation, Inheritance, Polymorphism )
       The practice of keeping fields within a class private, then providing access to those fields via public methods.
       Encapsulation is a protective barrier that keeps the data and code safe within the class itself.

       - providing only getters - read-only
       - providing only setters - write-only
       - control over the data( setters validations )
       - data hiding ( protects the data from unauthorized access and manipulation )
       - easy for testing ( Unit tests )


        */
    }
}
