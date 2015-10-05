import java.util.*;
class MyStack {
    Queue q1 = new LinkedList<Integer>();
    Queue q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        while (q1.size()>1) q2.offer(q1.poll());
        q1.poll();
        while (!q2.isEmpty()) q1.offer(q2.poll());
        //return i;
    }

    // Get the top element.
    public int top() {
        while (q1.size()>1) q2.offer(q1.poll());
        int i = (int)q1.peek();
        q2.offer(q1.poll());
        while (!q2.isEmpty()) q1.offer(q2.poll());
        return i;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}