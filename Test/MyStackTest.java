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

    // Cause-effect tests

    @Test
    public void testPush() {
        // Cause: push a value onto the stack
        stack.push("Hello");

        // Effect: stack is not empty and peek returns the pushed value
        assertFalse(stack.empty());
        assertEquals("Hello", stack.peek());
    }

    @Test
    public void testPop() {
        stack.push("Hello");
        // Cause: pop the value from the stack
        Object item = stack.pop();

        // Effect: stack is empty and the popped value is returned
        assertTrue(stack.empty());
        assertEquals("Hello", item);
    }


    }