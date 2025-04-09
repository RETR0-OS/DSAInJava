
import java.util.NoSuchElementException;

public class LinkedListImplementation{
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addFirst(10);
        ll.print();
        System.out.println(ll.removeLast());
        System.out.println(ll.removeFirst());
        ll.print();
        System.out.println(ll.getAt(2));
        System.out.println(ll.removeAt(2));
        ll.print();
    }
}
class LinkedList{
    private Node head;
    private int length;

    public LinkedList(){
        this.length = 0;
    }

    public void addLast(Object n){
        this.length++;
        Node node = new Node(n);
        if (this.head == null){
            this.head = node;
            return;
        }
        Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

    public void addFirst(Object n){
        this.length++;
        Node node = new Node(n);
        if (this.head == null){
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }

    public Object removeFirst(){
        if (this.head == null){
            throw new NoSuchElementException();
        }
        this.length--;
        Object ret = this.head.data;
        this.head = this.head.next;
        return ret;
    }

    public Object removeLast(){
        if (this.head == null){
            throw new NoSuchElementException();
        }
        Node cur = this.head;
        Node runner = this.head.next;
        while (runner.next != null){
            cur = cur.next;
            runner = runner.next;
        }
        cur.next = null;
        this.length--;
        Object ret = runner.data;
        return ret;
    }

    public int getLength(){
        return this.length;
    }

    public Node gethead(){
        return this.head;
    }

    private Node goToIdx(int idx){
        if (idx < 0 || idx > this.length - 1){
            throw new NoSuchElementException();
        }
        Node cur = this.head;
        for (int i=0; i<idx; i++){
            cur = cur.next;
        }
        return cur;
    }

    public Object getAt(int idx){
        Node cur = goToIdx(idx);
        return cur.data;
    }

    public Object removeAt(int idx){
        Node cur = goToIdx(idx-1);
        Object ret = cur.next.data;
        cur.next = cur.next.next;
        return ret;
    }

    public void print(){
        Node cur = this.head;
        if (cur == null){
            return;
        }
        while(cur.next != null){
            System.out.print(cur.data + " ---> ");
            cur = cur.next;
        }
        System.out.println(cur.data + "");
    }

}

class Node{
    public Object data;
    public Node next;
    public Node prev;

    public Node(Object d){
        this.data = d;
    }
} 
