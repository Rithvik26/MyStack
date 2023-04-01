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

    @Test
    public void testNonEmptyStack() {
        // Partition: non-empty stack
        stack.push("Hello");
        assertFalse(stack.empty());
    }

    @Test
    public void testPushToFullStack() {
        // Partition: full stack
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        try {
            stack.push(100);
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            // Effect: IllegalStateException is thrown
        }
    }

}