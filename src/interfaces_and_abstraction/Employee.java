package interfaces_and_abstraction;

public class Employee extends Person{

    private long id;

    public Employee(String name, String gender, long id) {
        super(name, gender);
        this.id = id;
    }

    @Override
    public void work() {
        if (id != 0){
            System.out.printf("%s works in the company", this.getName());
        }else {
            System.out.println("Not working!");
        }
    }
}
