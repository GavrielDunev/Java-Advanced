package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetReturnsExceptionWhenIndexLessThanZero() {
        customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetReturnsExceptionWhenIndexEqualToCount() {
        customLinkedList.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetReturnsExceptionWhenIndexBiggerThanCount() {
        customLinkedList.get(1);
    }

    @Test
    public void testGetElementFromValidIndex() {
        customLinkedList.add("Element");
        String expectedElement = "Element";
        Assert.assertEquals(expectedElement, customLinkedList.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementToIndexLessThanZero() {
        customLinkedList.set(-1, "Element");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementToIndexEqualToCount() {
        customLinkedList.set(0, "Element");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementToIndexBiggerThanCount() {
        customLinkedList.set(1, "Element");
    }

    @Test
    public void testSetElementToValidIndex() {
        customLinkedList.add("Element");
        customLinkedList.set(0, "String");
        String expectedElement = "String";
        Assert.assertEquals(expectedElement, customLinkedList.get(0));
    }

    @Test
    public void testAddElement() {
        customLinkedList.add("Element");
        String expectedElement = "Element";
        Assert.assertEquals(expectedElement, customLinkedList.get(0));
        customLinkedList.add("Second");
        expectedElement = "Second";
        Assert.assertEquals(expectedElement, customLinkedList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementAtIndexLessThanZero() {
        customLinkedList.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementAtIndexEqualToCount() {
        customLinkedList.removeAt(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveElementAtIndexBiggerThanCount() {
        customLinkedList.removeAt(1);
    }

    @Test
    public void testRemoveElementAtValidIndex() {
        customLinkedList.add("Element");
        String elementToBeRemoved = "Element";
        Assert.assertEquals(elementToBeRemoved, customLinkedList.removeAt(0));
        Assert.assertFalse(customLinkedList.contains(elementToBeRemoved));
    }

    @Test
    public void testRemoveElementByValidValue(){
        customLinkedList.add("Name");
        customLinkedList.remove("Name");
        Assert.assertFalse(customLinkedList.contains("Name"));
    }

    @Test
    public void testRemoveNonExistingElement() {
        Assert.assertEquals(-1, customLinkedList.remove("Name"));
    }

    @Test
    public void testIndexOfReturnsCorrectIndexOfExistingElement() {
        customLinkedList.add("First");
        customLinkedList.add("Second");
        customLinkedList.add("Third");
        Assert.assertEquals(2, customLinkedList.indexOf("Third"));
    }

    @Test
    public void testContainsElement() {
        customLinkedList.add("Element");
        Assert.assertTrue(customLinkedList.contains("Element"));
        Assert.assertFalse(customLinkedList.contains("Name"));
    }
}
