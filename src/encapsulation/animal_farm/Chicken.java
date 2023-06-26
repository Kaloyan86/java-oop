package encapsulation.animal_farm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                             this.name,
                             this.age,
                             this.calculateProductPerDay());
    }

    private double calculateProductPerDay() {
        double eggs = 0.75;

        if (this.age < 6) {
            eggs = 2;
        } else if (this.age < 12) {
            eggs = 1;
        }

        return eggs;
    }

    private void setName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
}
