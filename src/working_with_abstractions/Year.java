package working_with_abstractions;

public class Year {

    private static boolean isFebBigger;

    public Year(boolean isFebBigger) {
        Year.isFebBigger = isFebBigger;
        if (isFebBigger){
            Month.FEBRUARY.setDays(29);
        }
    }

    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31);

        private int days;

        Month(int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }
    }


}
