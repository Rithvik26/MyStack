import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

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

    @Test
    public void testPopEmpty() {
        // Cause: try to pop from an empty stack
        try {
            stack.pop();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            // Effect: IllegalStateException is thrown
        }
    }
    @Test
    public void testPeek() {
        // Cause: push a value onto the stack
        stack.push("Morning");

        // Effect: peek returns the pushed value without removing it
        assertFalse(stack.empty());
        assertEquals("Morning", stack.peek());
    }

    @Test
    public void testPeekEmpty() {
        // Cause: try to peek from an empty stack
        try {
            stack.peek();
            fail("Expected IllegalStateException");
        } catch (IllegalStateException e) {
            // Effect: IllegalStateException is thrown
        }
    }


    // Boundary value tests
    @Test
    public void testPushToEmptyStack() {
        // Boundary: push to empty stack
        stack.push("Hello");
        assertFalse(stack.empty());
        assertEquals("Hello", stack.peek());
    }

    @Test
    public void testPopFromFullStack() {
        // Boundary: pop from full stack
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        assertEquals(99, stack.pop());
    }
    @Test
    public void testPeekFromFullStack() {
        // Boundary: peek from full stack
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        assertEquals(99, stack.peek());
    }

    @Test
    public void testPrint() throws IOException {
        stack.push("Good");
        stack.push("Morning");

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             PrintStream stream = new PrintStream(out)) {
            System.setOut(stream);

            stack.print();

            String output = out.toString();
            assertEquals("Morning\nGood\n", output);
        } finally {
            System.setOut(System.out);
        }
    }
    }