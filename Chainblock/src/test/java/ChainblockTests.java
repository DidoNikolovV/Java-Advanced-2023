import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ChainblockTests {

    private Chainblock chainblock;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();

    }

    @Test
    public void testAddSingleElement() {

        chainblock.add(buildTransaction(1, TransactionStatus.SUCCESSFUL));

        assertEquals(1, chainblock.getCount());
        assertEquals(1, chainblock.getById(1).getId());
    }

    @Test
    public void testAddDoesntDuplicateElements() {

        chainblock.add(buildTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(buildTransaction(2, TransactionStatus.ABORTED));
        chainblock.add(buildTransaction(2, TransactionStatus.SUCCESSFUL));

        List<Transaction> actual = getListFrom(chainblock.getAllOrderedByAmountDescendingThenById());
        assertEquals(1, actual.get(0).getId());
        assertEquals(TransactionStatus.SUCCESSFUL, actual.get(0).getStatus());
        assertTranssactionIdsEqual(Arrays.asList(1, 2), actual);
        assertEquals(TransactionStatus.SUCCESSFUL, chainblock.getById(1).getStatus());
    }

    @Test
    public void testContainsTransaction() {
        chainblock.add(buildTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(buildTransaction(2, TransactionStatus.ABORTED));

        Transaction expected = buildTransaction(2, TransactionStatus.ABORTED);

        assertEquals(expected.getId(), chainblock.getById(2).getId());
    }

    @Test
    public void testContainsTransactionWithGivenId() {
        chainblock.add(buildTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(buildTransaction(2, TransactionStatus.ABORTED));

        assertEquals(2, chainblock.getById(2).getId());
    }

    @Test
    public void testGetCount() {
        chainblock.add(buildTransaction(1, TransactionStatus.SUCCESSFUL));
        chainblock.add(buildTransaction(2, TransactionStatus.ABORTED));

        assertEquals(2, chainblock.getCount());
    }


    @Test
    public void testChangeTransactionStatus() {
    }

    public static Transaction buildTransaction(int id, TransactionStatus status) {
        return new TransactionImpl(id, status, "from", "to", 42.0);
    }

    private static void assertTranssactionIdsEqual(List<Integer> expectedIds, List<Transaction> actual) {
        assertEquals(expectedIds.size(), actual.size());
        for (int i = 0; i < expectedIds.size(); i++) {
            assertEquals((int) expectedIds.get(i), actual.get(i).getId());
        }
    }

    private static <T> List<T> getListFrom(Iterable<T> iterable) {
        ArrayList<T> list = new ArrayList<>();
        for (T item : iterable) {
            list.add(item);
        }

        return list;
    }
}
