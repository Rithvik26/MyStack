public class MyStack {
    private Object[] stack;
    private int top;
    public MyStack() {
        stack = new Object[100];
        top = -1;
    }

    public boolean empty() {
        return top == -1;
    }

    public void push(Object item) {
        if (top == 99) {
            throw new IllegalStateException("Stack is full");
        }
        top++;
        stack[top] = item;
    }


    public Object peek() {
        return stack[top];
    }
}