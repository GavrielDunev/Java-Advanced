package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    public Computer computer;
    public Part part1;
    public Part part2;

    @Before
    public void setUp() {
        this.computer = new Computer("PC");
        part1 = new Part("Card", 500.00);
        part2 = new Part("CPU", 200.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullName() {
        new Computer(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetParts() {
        List<Part> parts = computer.getParts();
        parts.add(part1);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(computer.getName(), "PC");
    }

    @Test
    public void testGetTotalPrice() {
        computer.addPart(part1);
        computer.addPart(part2);
        double totalPrice = computer.getTotalPrice();
        Assert.assertEquals(totalPrice, 700.00, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullPart() {
        computer.addPart(null);
    }

    @Test
    public void testAddPartCorrectly() {
        computer.addPart(part1);
        computer.addPart(part2);
        Assert.assertEquals(computer.getParts().size(), 2);
    }

    @Test
    public void testRemovePart() {
        computer.addPart(part1);
        computer.addPart(part2);
        computer.removePart(part2);
        Assert.assertEquals(computer.getParts().size(), 1);
    }

    @Test
    public void testGetPartByName() {
        computer.addPart(part1);
        computer.addPart(part2);
        Part part = computer.getPart(part1.getName());
        Assert.assertEquals(part1.getName(), part.getName());
    }
}