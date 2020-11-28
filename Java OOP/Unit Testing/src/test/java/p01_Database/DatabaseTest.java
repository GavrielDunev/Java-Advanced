package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] ELEMENTS = {5, 1, 2, 7, 20};
    private Database database;

    @Before
    public void setConstructor() throws OperationNotSupportedException {
        this.database = new Database(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] elements = new Integer[0];
        Database database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        Database database = new Database(elements);
    }

    @Test
    public void testArrayLengthBetweenOneAndSixteen() throws OperationNotSupportedException {
        Integer[] databaseElements = database.getElements();
        Assert.assertEquals(databaseElements.length, ELEMENTS.length);
        for (int i = 0; i < databaseElements.length; i++) {
            Assert.assertEquals(ELEMENTS[i], databaseElements[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddIntegerElementAtNextFreeCell() throws OperationNotSupportedException {
        database.add(7);
        Assert.assertEquals(ELEMENTS.length + 1, database.getElements().length);
        Assert.assertEquals(ELEMENTS[3], database.getElements()[3]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveFromEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < ELEMENTS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveElementAtLastIndex() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(ELEMENTS.length - 1, database.getElements().length);
        Integer[] elementsInDatabase = database.getElements();
        for (int i = 0; i < elementsInDatabase.length; i++) {
            Assert.assertEquals(elementsInDatabase[i], database.getElements()[i]);
        }
    }
}
