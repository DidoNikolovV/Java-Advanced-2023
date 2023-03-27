package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.*;


public class DatabaseTests {

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCtorMoreThan16ElementsThrows() throws OperationNotSupportedException {
        Integer[] largerArray = new Integer[16 + 1];
        new Database(largerArray);

    }

    @Test
    public void testDatabaseCtorLessThan16ElementsThrows() throws OperationNotSupportedException {
        Integer[] smallerArray = new Integer[0];

        boolean threwException = false;
        try {
            new Database(smallerArray);
        } catch(Throwable e) {
            assertEquals(OperationNotSupportedException.class, e.getClass());
            threwException = true;
        }

        assertTrue(threwException);

    }

    @Test
    public void testCreateDatabaseCtor() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Database database = new Database(10,11, 12, 13, 14);

        Field elementsField = Database.class.getDeclaredField("elements");
        elementsField.setAccessible(true);
        Integer[] databaseElements = (Integer[]) elementsField.get(database);
        assertEquals(16, databaseElements.length);
    }

    @Test
    public void testDatabaseCtor() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14};
        Database database = new Database(expectedElements);
        Integer[] actualElements = database.getElements();
        assertEquals(expectedElements.length, actualElements.length);
        assertEquals(expectedElements[0], actualElements[0]);
        assertEquals(expectedElements[1], actualElements[1]);
        assertEquals(expectedElements[2], actualElements[2]);
        assertEquals(expectedElements[3], actualElements[3]);
        assertEquals(expectedElements[4], actualElements[4]);
        assertArraysEqualTo(expectedElements.length - 1, expectedElements, actualElements);

    }

    @Test
    public void testAdd() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);
        database.add(15);

        Integer[] actualElements = database.getElements();
        assertEquals(5 + 1, actualElements.length);
        assertArraysEqualTo(4, initialElements, actualElements);
        assertEquals(15, (int) actualElements[5]);
    }

    @Test
    public void testAddToSingleElementDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10};
        Database database = new Database(initialElements);
        database.add(11);

        Integer[] actualElements = database.getElements();
        assertEquals(2, actualElements.length);
        assertArraysEqualTo(0, initialElements, actualElements);
        assertEquals(11, (int) actualElements[1]);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddToMaxElementDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = new Integer[16];
        Database database = new Database(initialElements);

        database.add(11);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementThrows() throws OperationNotSupportedException {
        Integer[] initialElements = new Integer[16];
        Database database = new Database(initialElements);

        database.add(null);
    }

    @Test
    public void testRemove() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);
        database.remove();
        Integer[] actualElements = database.getElements();
        assertEquals(initialElements.length - 1, actualElements.length);
        assertArraysEqualTo(initialElements.length - 2, initialElements, actualElements);
    }

    @Test
    public void testRemoveFromSingleElementDatabase() throws OperationNotSupportedException {
        Integer[] initialElements = {10};
        Database database = new Database(initialElements);

        database.remove();
        Integer[] actualElements = database.getElements();
        assertEquals(0, actualElements.length);

    }

    @Test
    public void testRemoveTwice() throws OperationNotSupportedException {
        Integer[] initialElements = {10, 11, 12, 13, 14};
        Database database = new Database(initialElements);

        database.remove();
        database.remove();
        Integer[] actualElements = database.getElements();
        assertEquals(initialElements.length - 2, actualElements.length);
        assertArraysEqualTo(initialElements.length - 3, initialElements, actualElements);

    }

    @Test
    public void testGetElements() throws OperationNotSupportedException {
        Integer[] expectedElements = {10, 11, 12, 13, 14};
        Database database = new Database(expectedElements);
        Integer[] actualElements = database.getElements();
        assertEquals(expectedElements.length, actualElements.length);
        assertArraysEqualTo(actualElements.length - 1, expectedElements, actualElements);

    }


    private static void assertArraysEqualTo(int index, Integer[] expected, Integer[] actual) {
        assertTrue(expected.length > index);
        assertTrue(actual.length > index);

        for (int i = 0; i <= index; i++) {
            assertEquals("Mismatch at "+ i + " index", expected[i], actual[i]);
        }
    }
}
