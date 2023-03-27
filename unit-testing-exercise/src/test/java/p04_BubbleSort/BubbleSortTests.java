package p04_BubbleSort;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BubbleSortTests {
    @Test
    public void testSortWith1Element() {
        int[] elements = new int[] {1};
        int[] expected = new int[] {1};
        Bubble.sort(elements);
        assertEquals(expected[0], elements[0]);
    }

    @Test
    public void testSortWithMultipleNotSortedPositiveElements() {
        int[] elements = new int[] {3, 1, 2, 5, 7};
        int[] expected = new int[] {1, 2, 3, 5, 7};
        Bubble.sort(elements);
        assertEquals(expected[0], elements[0]);
        assertEquals(expected[1], elements[1]);
        assertEquals(expected[2], elements[2]);
        assertEquals(expected[3], elements[3]);
        assertEquals(expected[4], elements[4]);
    }

    @Test
    public void testSortWithMultipleSortedPositiveElements() {
        int[] elements = new int[] {1, 2, 3};
        int[] expected = new int[] {1, 2, 3};
        Bubble.sort(elements);
        assertEquals(expected[0], elements[0]);
        assertEquals(expected[1], elements[1]);
        assertEquals(expected[2], elements[2]);
    }

    @Test
    public void testSortWithMultipleNotSortedNegativeElements() {
        int[] elements = new int[] {-7, -1, -3};
        int[] expected = new int[] {-7, -3, -1};
        Bubble.sort(elements);
        assertEquals(expected[0], elements[0]);
        assertEquals(expected[1], elements[1]);
        assertEquals(expected[2], elements[2]);
    }

    @Test
    public void testSortWithMultipleSortedNegativeElements() {
        int[] elements = new int[] {-7, -3, -1};
        int[] expected = new int[] {-7, -3, -1};
        Bubble.sort(elements);
        assertEquals(expected[0], elements[0]);
        assertEquals(expected[1], elements[1]);
        assertEquals(expected[2], elements[2]);
    }

    @Test
    public void testSortWithPositiveAndNegativeElements() {
        int[] elements = new int[] {1, -1, 3, 5, -2};
        int[] expected = new int[] {-2, -1, 1, 3, 5};
        Bubble.sort(elements);

        assertEquals(expected[0], elements[0]);
        assertEquals(expected[1], elements[1]);
        assertEquals(expected[2], elements[2]);
        assertEquals(expected[3], elements[3]);
        assertEquals(expected[4], elements[4]);
    }



}
