
# Dependency Inversion

"**Depend on abstractions, not on concretions**"

The **Dependency Inversion principle** defines the concept that **high-level** modules should not depend on **low-level** modules. 

They both **should depend on abstractions**. 

It is better to **use interfaces** in the transmission of information **than specific classes**. 

In this way we will **rely more on abstraction than on concretion**.

Abstractions should **not rely on any implementation details**.​

Instead, the **details have to be based on abstractions**.​

The goal we are trying to achieve with the abstraction approach is to have **independent modules**.​

​In the following example, we have two classes **Button** and **Lamp**.

The **Button** class recieves a `poll()` message that determines whether or not a user has pressed it. 

And a **Lamp** class, which receives a **turnOn()** message and a **turnOff()** message:

```java
public class Button() {

   private Lamp lamp;

   public Button(Lamp lamp) {
        this.lamp = lamp;
    }

   public void poll() {

      if (something) {

         lamp.turnOn();
      } else {

         lamp.turnOff();
      }
   }
}
```
**Button** class **depends directly on Lamp** class: if Lamp changes, then Button will have to be changed too.

Furthermore, **Button class is not reusable**: you can’t use it to switch on a coffee machine, for example.

The above code is a violation of the **Dependency Inversion principle**.

To solve the design issue behind the code above, we need to create a **middle-layer** where to define an **abstract interface associated with Button** and implemented by any classes like Lamp:

```java
public interface SwitchableDevice {

    void turnOn();
    void turnOff();
}
```
Now, the **Button** class depends on the **SwitchableDevice** interface not to the concrete class suchs as **Lamp**:
```java 
public class Button {

    private SwitchableDevice switchableDevice;

    public Button(SwitchableDevice switchableDevice) {
        this.switchableDevice = switchableDevice;
    }

    public void poll() {

        if (something) {

            switchableDevice.turnOn();
        } else {

            switchableDevice.turnOff();
        }
    }
}
```
The **Lamp** class should implements **SwitchableDevice** interface:

```java
public class Lamp implements SwitchableDevice {

    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}
```

The **Button** class can accepts **any implementation of the SwitchableDevice interface**.

In our case this a **Lamp** but it could be **any other device** which implements the **SwitchableDevice** interface:

```java
public class Main {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Button button = new Button(lamp);
    }
}
```

The design above allows a **Button** to control any device that is willing to implement the **SwitchableDevice** interface. 

It also means that **Button** will be **able to control objects** that have **not yet been invented**, and this makes the application **more flexible**.
