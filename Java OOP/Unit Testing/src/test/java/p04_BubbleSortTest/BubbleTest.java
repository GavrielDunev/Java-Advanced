package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    private static final int[] NUMBERS = {7, 20, 11, 77, 6, 21};

    @Test
    public void testSortsTheNumbersCorrectly() {
        Bubble.sort(NUMBERS);
        int[] expectedSortedArray = {6, 7, 11, 20, 21, 77};
        for (int i = 0; i < expectedSortedArray.length; i++) {
            Assert.assertEquals(expectedSortedArray[i], NUMBERS[i]);
        }
    }
}
