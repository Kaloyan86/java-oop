package interfaces_and_abstraction;

public abstract class Person {

    private String name;
    private String gender;

    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    // abstract method
    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", gender='" + gender + '\'' +
               '}';
    }
}
