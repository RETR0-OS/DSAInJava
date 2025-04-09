
public class BSTImplementation{
    public static void main(String[] args){
        BinSearchTree<Integer> tree = new BinSearchTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(1);
        tree.printInOrder();
        System.out.println(tree.search(100));
        tree.printPreOrder();
        tree.printPostOrder();
    }
}

class BinSearchTree<E extends Comparable<E>>{

    private Node<E> root;

    public void add(E data){
        Node<E> node = new Node<>(data);
        if (this.root == null){
            this.root = node;
            return;
        }
        Node<E> cur = this.root;
        while(true){
            if(cur.data.compareTo(data) > 0){
                if (cur.left == null){
                    cur.left = node;
                    break;
                }
                else{
                    cur = cur.left;
                }
            }
            else if(cur.data.compareTo(data) < 0){
                if (cur.right == null){
                    cur.right = node;
                    break;
                }
                else{
                    cur = cur.right;
                }
            }
            else{
                break;
            }
        }
    }

    private void printInOrder(Node<E> cur){
        if (cur == null){
            return;
        }
        if (cur.left != null){
            printInOrder(cur.left);
        }
        System.out.print(" " + cur.data + " ");
        if(cur.right != null){
            printInOrder(cur.right);
        }
    }

    public void printInOrder(){
        printInOrder(this.root);
        System.out.println();
    }

    private Node<E> search(Node<E> node, E element){
        Node<E> cur = node;
        if (cur == null){
            return null;
        }
        else if(cur.data.equals(element)){
            return cur;
        }
        else if(cur.data.compareTo(element) < 0){
            return search(cur.right, element);
        }
        else{
            return search(cur.left, element);
        }
    }

    public boolean search(E element){
        Node<E> node = search(this.root, element);
        if (node == null){
            return false;
        }
        return true;
    }

    private void printPreOrder(Node<E> cur){
        if (cur == null){
            return;
        }
        System.out.print(" " + cur.data + " ");
        if (cur.left != null){
            printPreOrder(cur.left);
        }
        if(cur.right != null){
            printPreOrder(cur.right);
        }
    }
    
    public void printPreOrder(){
        printPreOrder(this.root);
        System.out.println();
    }

    private void printPostOrder(Node<E> cur){
        if (cur == null){
            return;
        }
        if (cur.left != null){
            printPostOrder(cur.left);
        }
        if(cur.right != null){
            printPostOrder(cur.right);
        }
        System.out.print(" " + cur.data + " ");
    }

    public void printPostOrder(){
        printPostOrder(this.root);
        System.out.println();
    }

}

class Node<E extends Comparable<E>>{
    public E data;
    public Node<E> left;
    public Node<E> right;

    public Node(E d){
        this.data = d;
    }
}