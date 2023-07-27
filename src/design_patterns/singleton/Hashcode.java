package design_patterns.singleton;

public class Hashcode {

    private static Hashcode instance;
    private String point;

    private Hashcode(String point) {
        this.point = point;
    }

    public static Hashcode getInstance(String point) {
        if (instance == null) {
            instance = new Hashcode(point);
        }
        return instance;
    }

    public String getPoint() {
        return point;
    }
}




















