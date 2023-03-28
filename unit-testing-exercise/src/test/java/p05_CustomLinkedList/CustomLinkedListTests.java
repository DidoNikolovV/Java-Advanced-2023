package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

import javax.management.ListenerNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomLinkedListTests {



    private CustomLinkedList<Integer> customLinkedList;
    @Before
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(1);
        customLinkedList.add(2);
    }

    @Test
    public void testGetWith1Element() {
        Integer actual = customLinkedList.get(0);
        Integer expected = customLinkedList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWithInvalidIndexShouldThrow() {
        int index = 2;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.get(2);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());

    }

    @Test
    public void testSet() {
        customLinkedList.set(0, 3);
        Integer actual = customLinkedList.get(0);
        Integer expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testSetWithIndexGreaterThanCountShouldThrow() {
        int index = 3;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.set(index, 8);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());
    }

    @Test
    public void testSetWithIndexEqualToCountShouldThrow() {
        int index = 2;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.set(index, 8);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());
    }

    @Test
    public void testSetWithIndexLessThan0ShouldThrow() {
        int index = -1;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.set(index, 8);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());
    }

    @Test
    public void testRemoveAtWithIndexGreaterThanCountShouldThrow() {
        int index = 3;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.removeAt(index);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());
    }

    @Test
    public void testRemoveAtWithIndexEqualToCountShouldThrow() {
        int index = 2;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.removeAt(index);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());
    }

    @Test
    public void testRemoveAtWithIndexLessThan0ShouldThrow() {
        int index = -1;
        IllegalArgumentException actualException = null;
        try {
            customLinkedList.removeAt(index);
        } catch(IllegalArgumentException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid index: " + index, actualException.getMessage());
    }

    @Test
    public void testRemoveAt() {
        int index = 1;
        Integer actual = customLinkedList.removeAt(index);
        Integer expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveShouldReturnIndexOfTheElement() {
        Integer actual = customLinkedList.remove(2);
        Integer expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveShouldReturnMinus1WhenElementDoesntExist() {
        Integer expected = -1;
        Integer actual = customLinkedList.remove(3);
        assertEquals(expected, actual);
    }

}
