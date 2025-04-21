import java.util.NoSuchElementException;

public class StackImplementation{
    public static void main(String[] args){
        Stack s = new Stack();
        s.print();
        s.push(10);
        s.print();
        s.push(20);
        s.push(30);
        s.push(50);
        s.print();
        s.pop();
        s.print();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.print();
        s.push(100);
        s.print();
    }
}

class Stack{
    private Node top;
    private int size;

    public Stack(){
        this.size = 0;
    }

    public void push(Object d){
        Node node = new Node(d);
        node.next = this.top;
        this.size++;
        this.top = node;
    }

    public Object pop(){
        if (this.top == null){
            throw new NoSuchElementException("Underflow error: Stack is already empty!");
        }
        Object ret = this.top.data;
        this.top = this.top.next;
        return ret;
    }

    public Object peek(){
        if (this.top == null){
            return null;
        }
        return this.top.data;
    }

    public void print(){
        Node cur = this.top;
        if(cur == null){
            return;
        }
        while(cur.next != null){
            System.out.print(cur.data + " ---> ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }


}

class Node{
    public Object data;
    public Node next;

    public Node(Object d){
        this.data = d;
    }
}
