import static org.junit.Assert.*;
import org.junit.*;
public class MyStackTest {
    private MyStack stack;
    @Before
    public void setUp() {
        stack = new MyStack();
    }

    // Equivalence partitioning tests
    @Test
    public void testEmptyStack() {
        // Partition: empty stack
        assertTrue(stack.empty());
    }
}