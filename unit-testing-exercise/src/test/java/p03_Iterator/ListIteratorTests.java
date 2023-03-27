package p03_Iterator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;


public class ListIteratorTests {

    private ListIterator iteratorWith_0_1_2;

    @Before
    public void setUp() throws OperationNotSupportedException {
        iteratorWith_0_1_2 = new ListIterator("0", "1", "2", "3");
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testCtorAndIterator() throws OperationNotSupportedException {

        assertEquals("0", iteratorWith_0_1_2.print());
        iteratorWith_0_1_2.move();
        assertEquals("1", iteratorWith_0_1_2.print());
        iteratorWith_0_1_2.move();
        assertEquals("2", iteratorWith_0_1_2.print());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCtorWhenNullArgumentThrows() throws OperationNotSupportedException {
       new ListIterator(null);

    }

    @Test
    public void testHasNext()  {
        assertTrue(iteratorWith_0_1_2.hasNext());
    }

    @Test
    public void testHasNextWhenEmpty() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testHasNextWhenReachedEnd() {
        iteratorWith_0_1_2.move();
        iteratorWith_0_1_2.move();
        iteratorWith_0_1_2.move();
        assertFalse(iteratorWith_0_1_2.hasNext());
    }

    @Test
    public void testHasNextWhenReachedMiddle() {
        iteratorWith_0_1_2.move();
        assertTrue(iteratorWith_0_1_2.hasNext());
    }


    @Test
    public void testMove() {
        assertTrue(iteratorWith_0_1_2.move());

        assertEquals("1", iteratorWith_0_1_2.print());
    }

    @Test
    public void testMoveWhenEmpty() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();
        assertFalse(iterator.move());
    }

    @Test
    public void testMoveWhenSingleElement() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator("1");
        assertFalse(iterator.move());
    }

    @Test
    public void testMultipleMoveWhenReachedEnd() throws OperationNotSupportedException {
        iteratorWith_0_1_2 = new ListIterator("0", "1");
        iteratorWith_0_1_2.move();
        iteratorWith_0_1_2.move();
        assertFalse(iteratorWith_0_1_2.move());
    }

    @Test
    public void testMoveWhenReachedMiddle() {
        iteratorWith_0_1_2.move();
        assertTrue(iteratorWith_0_1_2.move());
    }


    @Test
    public void testPrintWhenEmpty() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

//        expectedException.expectMessage("Invalid Operation!");
//        iterator.print();

        IllegalStateException actualException = null;
        try {
            iterator.print();
        } catch(IllegalStateException e) {
            actualException = e;
        }

        assertNotNull(actualException);
        assertEquals("Invalid Operation!", actualException.getMessage());
    }

}
