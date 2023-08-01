package carShop;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarShopTests {

    private CarShop carShop;
    private Car car;

    @Before
    public void setUp() {
        carShop = new CarShop();
        car = new Car("BMW", 231, 15000);

        carShop.add(car);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenGetCarsReturnUnmodifiableList() {
        carShop.getCars().set(0, car);
    }

    @Test
    public void whenGetCarsReturnCarList() {
        List<Car> cars = carShop.getCars();

        Assert.assertEquals(1, cars.size());
    }

    @Test
    public void whenGetCountReturnCorrectCount() {

        Assert.assertEquals(1, carShop.getCount());
    }

    @Test
    public void whenGivenShopFindAllCarsWithMaxHorsePowerReturnCorrect() {
        Car ford = new Car("Ford", 450, 45000);
        Car vw = new Car("VW", 150, 15000);
        Car audi = new Car("A4", 150, 25000);

        carShop.add(ford);
        carShop.add(vw);
        carShop.add(audi);

        List<Car> expectedCars = List.of(car, ford);
        List<Car> actualCars = carShop.findAllCarsWithMaxHorsePower(150);

        Assert.assertEquals(expectedCars, actualCars);
    }

    @Test(expected = NullPointerException.class)
    public void whenAddNullCarShouldThrow() {

        Car car = null;
        carShop.add(car);
    }

    @Test
    public void whenAddCarShouldAddSuccess() {

        Car car = new Car("HONDA", 150, 5000);
        carShop.add(car);

        Assert.assertEquals(2, carShop.getCount());
        Assert.assertEquals("HONDA", carShop.getCars().get(1).getModel());
    }

    @Test
    public void whenRemoveCarShouldRemoveSuccess() {

        Car car = new Car("HONDA", 150, 5000);
        carShop.add(car);

        Assert.assertEquals(2, carShop.getCount());
        Assert.assertEquals("HONDA", carShop.getCars().get(1).getModel());

        Assert.assertTrue(carShop.remove(car));
        Assert.assertEquals(1, carShop.getCount());
    }

    @Test
    public void whenGetTheMostLuxuryCarReturnCorrect() {
        Car ford = new Car("Ford", 450, 45000);
        Car vw = new Car("VW", 150, 15000);
        Car audi = new Car("A4", 150, 25000);

        carShop.add(ford);
        carShop.add(vw);
        carShop.add(audi);

        Car theMostLuxuryCar = carShop.getTheMostLuxuryCar();

        Assert.assertEquals(ford, theMostLuxuryCar);
    }

    @Test
    public void whenFindAllCarByModelReturnCorrect() {
        Car ford = new Car("Ford", 450, 45000);
        Car ford1 = new Car("Ford", 150, 15000);
        Car audi = new Car("A4", 150, 25000);

        carShop.add(ford);
        carShop.add(ford1);
        carShop.add(audi);

        List<Car> expectedCars = List.of(ford, ford1);
        List<Car> actualCars = carShop.findAllCarByModel("Ford");

        Assert.assertEquals(expectedCars, actualCars);
    }
}

