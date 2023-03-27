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
    }

    @Test
    public void testGetWith1Element() {
        customLinkedList.add(1);
        Integer actual = customLinkedList.get(0);
        Integer expected = customLinkedList.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWithInvalidIndexShouldThrow() {

        int index = 2;
        customLinkedList.add(1);
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
        customLinkedList.add(1);
        customLinkedList.add(2);
        customLinkedList.set(0, 3);
        Integer actual = customLinkedList.get(0);
        Integer expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testSetWithInvalidIndexShouldThrow() {
        customLinkedList.add(1);
        customLinkedList.add(2);
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

}
