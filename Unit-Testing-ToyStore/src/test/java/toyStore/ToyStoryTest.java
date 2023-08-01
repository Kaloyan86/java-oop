package toyStore;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.OperationNotSupportedException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToyStoryTest {

    private ToyStore toyStore;

    @Before
    public void init() {
        toyStore = new ToyStore();
    }

    @Test
    public void testInitToyStore() {
        Map<String, Toy> toyShelf = new LinkedHashMap<>();
        toyShelf.put("A", null);
        toyShelf.put("B", null);
        toyShelf.put("C", null);
        toyShelf.put("D", null);
        toyShelf.put("E", null);
        toyShelf.put("F", null);
        toyShelf.put("G", null);

        Assert.assertEquals(toyShelf, toyStore.getToyShelf());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToyToNonExistingShelfShouldThrow() throws OperationNotSupportedException {
        Toy toy = new Toy("Comsed", "1");
        toyStore.addToy("H", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenAddToyToTakenShelfShouldThrow() throws OperationNotSupportedException {
        Toy toy1 = new Toy("Lego", "1");
        Toy toy2 = new Toy("Fisher Price", "2");

        toyStore.addToy("A", toy1);
        toyStore.addToy("A", toy2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void whenAddDuplicateToyToShelfShouldThrow() throws OperationNotSupportedException {
        Toy toy = new Toy("Lego", "1");

        toyStore.addToy("A", toy);
        toyStore.addToy("B", toy);
    }

    @Test
    public void whenAddToyToShelfShouldAddSuccess() throws OperationNotSupportedException {
        Toy toy = new Toy("Lego", "1");

        toyStore.addToy("A", toy);

        Toy toy1 = toyStore.getToyShelf().get("A");

        Assert.assertEquals(toy, toy1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRemoveToyFromNonExistingShelfShouldThrow() throws OperationNotSupportedException {
        Toy toy = new Toy("Lego", "1");

        toyStore.addToy("A", toy);

        toyStore.removeToy("H", toy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenRemoveNonExistingToyShouldThrow() throws OperationNotSupportedException {
        Toy toy = new Toy("Lego", "1");
        Toy toy2 = new Toy("Fisher Price", "2");

        toyStore.addToy("A", toy);

        toyStore.removeToy("A", toy2);
    }

    @Test
    public void whenRemoveGivenToyShouldRemoveSuccess() throws OperationNotSupportedException {
        Toy toy = new Toy("Lego", "1");
        toyStore.addToy("A", toy);

        String result = toyStore.removeToy("A", toy);

        Assert.assertNull(toyStore.getToyShelf().get("A"));
        Assert.assertEquals("Remove toy:1 successfully!", result);
    }
}