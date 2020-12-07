package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;
    private Computer computer2;

    @Before
    public void setUp() {
        this.computerManager = new ComputerManager();
        this.computer = new Computer("HP", "Pro", 400.00);
        this.computer2 = new Computer("Asus", "Mega", 600.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers() {
        computerManager.addComputer(computer);
        computerManager.getComputers().remove(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNull(){
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerTwice() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer);
    }

    @Test
    public void testAddCorrectly(){
        computerManager.addComputer(computer);
        Assert.assertEquals(computerManager.getComputers().get(0).getManufacturer(), computer.getManufacturer());
        Assert.assertEquals(computerManager.getComputers().get(0).getModel(), computer.getModel());
    }

    @Test
    public void testRemoveComputer() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        computerManager.removeComputer(computer2.getManufacturer(), computer2.getModel());
        Assert.assertEquals(computerManager.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithNullManufacturer() {
        computerManager.getComputer(null, "HP");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithNullModel() {
        computerManager.getComputer("Dell", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExistingComputer() {
        computerManager.getComputer("HP", "Pro");
    }

    @Test
    public void testGetComputerReturnsCorrectly() {
        computerManager.addComputer(computer);
        Computer returned = computerManager.getComputer(this.computer.getManufacturer(), this.computer.getModel());
        Assert.assertNotNull(returned);
        Assert.assertEquals(returned.getManufacturer(), this.computer.getManufacturer());
        Assert.assertEquals(returned.getModel(), this.computer.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerWithNullParam() {
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerReturnCorrectCollection() {
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        List<Computer> computersByManufacturer = computerManager.getComputersByManufacturer(computer2.getManufacturer());
        Assert.assertNotNull(computersByManufacturer);
        Assert.assertEquals(computer2.getManufacturer(), computersByManufacturer.get(0).getManufacturer());
    }
}