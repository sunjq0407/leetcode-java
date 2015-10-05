import java.util.*;
class MyQueue {
    // Push element x to the back of queue.
    Stack stk1 = new Stack<Integer>();
    Stack stk2 = new Stack<Integer>();
    public void push(int x) {
        stk1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while (stk1.size()!=1) stk2.push(stk1.pop());
        stk1.pop();
        while (!stk2.empty()) stk1.push(stk2.pop());
    }

    // Get the front element.
    public int peek() {
        while (stk1.size()!=1) stk2.push(stk1.pop());
        int i = (int)stk1.peek();
        stk2.push(stk1.pop());
        while (!stk2.empty()) stk1.push(stk2.pop());
        return i;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stk1.empty();
    }
}