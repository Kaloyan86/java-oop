package design_patterns.singleton;

public class HashcodeDemo {

    public static void main(String[] args) {

        Hashcode instance = Hashcode.getInstance("Kaloyan");
        Hashcode instance2 = Hashcode.getInstance("Peter");

        System.out.println(instance.getPoint().hashCode());
        System.out.println(instance2.getPoint().hashCode());
        System.out.println("Peter".hashCode());

    }
}
