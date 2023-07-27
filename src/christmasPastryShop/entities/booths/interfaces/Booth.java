package christmasPastryShop.entities.booths.interfaces;

public interface Booth {
    int getBoothNumber();

    int getCapacity();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    double getBill();

    void clear();
}
