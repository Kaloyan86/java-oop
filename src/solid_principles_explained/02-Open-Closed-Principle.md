
# Open Closed Principle

"The code shuold be **open for extension**, but **closed for modification**".

Software entities (**classes**, **modules**, **methods**, etc.) should be extendable without actually changing the contents of the class you’re extending. 

If we could follow this principle strongly enough, it is possible to then modify the behavior of our code **without ever touching** a piece of **the original code**.


In the following example, we have the **CalculateArea** class which calculate the area of various shapes.

- **CalculateArea** class:
```java
public class CalculateArea {

    public static double calculate(Object obj) {

        double area = 0.0;
        if (obj instanceof Rectangle) {

            Rectangle rectangle = (Rectangle) obj;
            area = rectangle.getWidth() * rectangle.getHeight();

        }else if (obj instanceof Circle){

            Circle circle = (Circle) obj;
            area = circle.getRadius() * circle.getRadius() * Math.PI;
        }

        return area;
    }
}

```

- **Circle** class:

```java
public class Circle {

    private double radius;
    // TODO add getters and setters
}
``` 


- **Rectangle** class:

```java
public class Rectangle {

    private  double width;
    private  double height;
    // TODO add getters and setters

}
``` 

If we want to add **square** for example, we have to **modify** the `calculate()` method in the **CalculateArea** class.

**Thus will break the open-closed principle**.

According to this principle, **we can’t modify**, but **we can extend**.

To overcome this problem, we have to **add abstraction** to the `calculate()` method.

We have to **delegate** the responsibility of providing the calculation of the area inside the shape itself.

Each **shape** must have **own logic** to calculate its area.

See the solution of the problem in the following code: 

- First we add **abstraction** by creating the **Shape** Interface.

Then, we declare the `calculateArea()` method to the **Shape** Interface.

```java
public interface Shape {
    double calculateArea();
}
```

- By implementing the **Shape** Interface, all shapes classes are obligatory to implement the `calculateArea()` method.
- **Circle** class:

```java
public class Circle implements Shape {

    private double radius;
    // TODO add getters and setters

    
    @Override
    public double calculateArea() {
        return getRadius() * getRadius() * Math.PI;
    }
}
```

- **Rectangle** class:

```java
public class Rectangle implements Shape {

    private  double width;
    private  double height;
    // TODO add getters and setters


    @Override
    public double calculateArea() {
        return getWidth() * getHeight();
    }
}
``` 

- **Square** class:

```java
public class Square implements Shape {

    private double side;

    // TODO add getters and setters
   
    @Override
    public double calculateArea() {
        return getSide() * getSide();
    }
}

```

- In the end our **CalculateArea** class should look like this:

```java
public class CalculateArea {

    public static double calculate(Shape shape) {
        return shape.calculateArea();
    }
}
```

By using the **Open-Closed principle**, we can add a square's area **without modifying** the CalculateArea class, so we can be sure our existing application won't be affected.

Applying **Open-Closed principle** to our projects limits the need to change source code once it has been written, tested and debugged.

This **reduces the risk of introducing new bugs** to existing code, leading to more robust software.
