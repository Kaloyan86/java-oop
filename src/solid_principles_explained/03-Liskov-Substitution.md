
# Liskov Substitution

The **Liskov substitution principle**, written by **Barbara Liskov** in 1988, states that functions that reference base classes must be able to use objects of derived (child) classes without knowing it.

In other words, principle defines that objects of a **superclass** shall be **replaceable** with objects of its **subclasses** without breaking the application.

That requires the objects of your subclasses to **behave in the same way** as the objects of your superclass.

## OCP vs LSP​

The Liskov substitution principle is just an **extension** of the **Open-closed** principle. 

That means that we are able to implement the Open-closed principle through **additional objects**, **inheritance**, and **polymorphism**.​

We must make sure that new derived classes are extending the base classes **without changing their behavior**. 

## LSP – Violations and Solutions​

The **LSP** is applicable when there’s a **supertype-subtype inheritance** relationship by either **extending** a class or **implementing** an interface. 

We can think of the methods defined in the supertype as **defining a contract**.

Every subtype is expected to **stick** to **this contract**. 

If a subclass does not adhere to the superclass’s contract, it’s **violating the LSP**.

This code snippet shows what violates LSP and how we can fix it:

```java
public interface Vehicle {
 
    void startEngine();
    void accelerate();
}
```
Above, we define a simple **Vehicle** Interface with a couple of methods that all vehicles should be able to fulfill – turning on the engine, and accelerating forward.

The MotorCar class implements the Vehicle Interface and its methods `startEngine()` and `accelerate()`.

```java
public class MotorCar implements Vehicle {
 
    private Engine engine;
 
    public void startEngine() {
        // start the engine!
        engine.on();
    }
 
    public void accelerate() {
        // accelerate
        engine.powerOn(1000);
    }
}
```

As the above code describes, we have an **engine** that we can **turn on**, and we can **increase the power**.

But what will happen if we want to add an **electric car**.

```java
public class ElectricCar implements Vehicle {
 
    public void startEngine() {
        throw new Error("The electric cars have no engine!");
    }
 
    public void accelerate() {
        // accelerate
    }
}
```
The electric car is a vehicle, however it does not have an engine and hence, the method `startEngine()` cannot be implemented.

These are the kinds of problems that **violation** of Liskov Substitution Principle leads to, and they can most usually be recognized by a **method that does nothing**, or even **can’t be implemented**.

The **solution** to these problems is a correct **inheritance hierarchy**, and in our case, we would solve the problem by differentiating interfaces of vehicles with and without engines.


From the Vehicle Interface we remove the `startEngine()` method.

```java
public interface Vehicle {
    void accelerate();
}
```

Then, we create the **ElectricVehicle** interface which **extends the Vehicle interface** and has his own method - `batteryLife()`

```java
public interface ElectricVehicle extends Vehicle{

    int batteryLife();
}
```
So, we create an interface **Car** which extends Vehicle, where is more appropriate to add the `startEngine()` - method.

```java
public interface Car extends Vehicle{
    void startEngine();
}
```

The **MotorCar** class should implement the **Car** interface:

```java
public class MotorCar implements Car {
 
    private Engine engine;
 
    public void startEngine() {
        // start the engine!
        engine.on();
    }
 
    public void accelerate() {
        // accelerate
        engine.powerOn(1000);
    }
}
```

And the **ElectricCar** class implements the **ElectricVehicle** interface:

```java
public class ElectricCar implements ElectricVehicle{

    @Override
    public int batteryLife() {
        // battery life
    }

    @Override
    public void accelerate() {
        // accelerate
    }
}
```

Thus our **MotorCar** and **ElectricCar** classes become **more specialized** while **adhering to the Liskov Substitution Principle.**

