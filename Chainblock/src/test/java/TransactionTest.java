import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransactionTest {

    private Transaction transaction;

    @Before
    public void setUp() {
        this.transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "from", "to", 42.0);
    }

    @Test
    public void testGetId() {
        assertEquals(1, transaction.getId());
    }

    @Test
    public void testGetStatus() {
        assertEquals(TransactionStatus.SUCCESSFUL, transaction.getStatus());
    }

    @Test
    public void testGetFrom() {
        assertEquals("from", transaction.getFrom());

    }

    @Test
    public void testGetTo() {
        assertEquals("to", transaction.getTo());
    }

    @Test
    public void testGetAmount() {
        assertEquals(42.0, transaction.getAmount(), 0);

    }
}
