package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private static final String[] ELEMENTS = {"First", "Second"};
    private ListIterator listIterator;
    @Before
    public void setConstructor() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrownExceptionWhenNullParameter() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator((String[]) null);
    }

    @Test
    public void testConstuctorStoreStringsInList() throws OperationNotSupportedException {
        Assert.assertEquals(ELEMENTS[0], this.listIterator.print());
        listIterator.move();
        Assert.assertEquals(ELEMENTS[1], listIterator.print());
    }

    @Test
    public void testHasNextReturnsTrue() {
        Assert.assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextReturnsFalse() {
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMoveReturnsTrue() {
        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMoveReturnsFalse() {
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintReturnsExceptionWhenNullElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintReturnsCorrectElement() {
        Assert.assertEquals(ELEMENTS[0], listIterator.print());
        listIterator.move();
        Assert.assertEquals(ELEMENTS[1], listIterator.print());
    }
}
