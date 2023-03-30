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
}