package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;


public class BankVaultTest {
    private BankVault bankVault;
    private Item item1;
    private Item item2;

    @Before
    public void setUp() {
        this.bankVault = new BankVault();
        this.item1 = new Item("Ivan", "5");
        this.item2 = new Item("Pesho", "4");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetVaultCells() {
        Map<String, Item> vaultCells = bankVault.getVaultCells();
        vaultCells.put("A1", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemNotExistingCell() throws OperationNotSupportedException {
        bankVault.addItem("C205", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNotNullCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A1", item2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddExistingItem() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A2", item1);
    }

    @Test
    public void testAddItemCorrectly() throws OperationNotSupportedException {
        String item = bankVault.addItem("A1", item1);
        Assert.assertEquals(item, String.format("Item:%s saved successfully!", item1.getItemId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemNotExistingCell() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.removeItem("Sda2321", item1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveItemNotExisting() {
        bankVault.removeItem("A1", item1);
    }

    @Test
    public void testRemoveItemCorrectly() throws OperationNotSupportedException {
        bankVault.addItem("A1", item1);
        bankVault.addItem("A2", item2);
        String remove = bankVault.removeItem("A2", item2);
        Assert.assertFalse(bankVault.getVaultCells().containsValue(item2));
        Assert.assertEquals(remove, String.format("Remove item:%s successfully!", item2.getItemId()));
    }
}