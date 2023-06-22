package working_with_abstractions;

public class Demo {

    public static void main(String[] args) {

//        Months[] months = Months.values();
//        for (Months month : months) {
//
//            System.out.println(month + " " + month.getDays());
//        }
        Year year = new Year(true);

        System.out.println(Year.Month.FEBRUARY.getDays());
    }
}
