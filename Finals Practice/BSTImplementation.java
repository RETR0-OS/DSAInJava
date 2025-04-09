
import java.util.NoSuchElementException;


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
        tree.remove(100);
        tree.printInOrder();
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
        return node != null;
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

    private Node<E> findParent(E e, Node<E> n, Node<E> p){
        Node<E> cur = n;
        Node<E> parent = p;
        if (cur == null){
            throw new NoSuchElementException();
        }
        if (e.compareTo(cur.data) < 0){
            parent = cur;
            cur = cur.left;
            return findParent(e, cur, parent);
        }
        else if(e.compareTo(cur.data) > 0){
            parent = cur;
            cur = cur.right;
            return findParent(e, cur, parent);
        }
        else{
            return parent;
        }
    }

    public E remove(E e){
        if(this.root == null){
            throw new NoSuchElementException();
        }
        Node<E> pNode = findParent(e, this.root, null);
        System.out.println("Parent is: " + pNode.data);
        Node<E> rNode = null;
        if (e.compareTo(pNode.data) < 0){
            rNode = pNode.left;
        }
        else if (e.compareTo(pNode.data) > 0){
            rNode = pNode.right;
        }

        if (rNode.left != null && rNode.right != null){
            // two children;
        }
        else if (rNode.left != null ^ rNode.right != null){
            if(e.compareTo(pNode.data) < 0){
                if(rNode.left != null){
                    pNode.left = rNode.left;
                }
                else{
                    pNode.left = rNode.right;
                }
            }
            else{
                if(rNode.left != null){
                    pNode.right = rNode.left;
                }
                else{
                    pNode.right = rNode.right;
                }
            }
        }
        else{
            if(e.compareTo(pNode.data) < 0){
                pNode.left = null;
            }
            else{
                pNode.right = null;
            }
        }
        return rNode.data;
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