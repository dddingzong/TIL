package stacks.week6.example1;

import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    public BinaryTree( ) { root = null; }

    public Node getRoot( ) { return root; }
    public void setRoot(Node newRoot) { root = newRoot; }

    public boolean isEmpty( ) { return root == null; }

    public void preorder(Node n) {
        if (n != null) {
            System.out.print(n.getKey()+" ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public void inorder(Node n){
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getKey()+" ");
            inorder(n.getRight());
        }
    }

    public void postorder(Node n) {
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getKey()+" ");
        }
    }
    
    public void levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Node t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.getKey()+" ");
            if (t.getLeft() != null)
                q.add(t.getLeft());
            if (t.getRight() != null)
                q.add(t.getRight());
        }
    }

    public int size(Node n) {
        if (n == null)
            return 0;
        else
            return (1 + size( n.getLeft() ) + size( n.getRight() ));
    }

    public int height(Node n) {
        if (n == null)
            return 0;
        else
            return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
    }

    public static boolean isEqual(Node n, Node m){
        if(n==null || m==null)
            return n == m;

        if (n.getKey().compareTo(m.getKey()) != 0)
            return false;

        return( isEqual(n.getLeft(), m.getLeft()) &&
                isEqual(n.getRight(), m.getRight()) );
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(100,null,null); Node n2 = new Node(200,null,null);
        Node n3 = new Node(300,null,null); Node n4 = new Node(400,null,null);
        Node n5 = new Node(500,null,null); Node n6 = new Node(600,null,null);
        Node n7 = new Node(700,null,null); Node n8 = new Node(800,null,null);

        n1.setLeft(n2); n1.setRight(n3);
        n2.setLeft(n4); n2.setRight(n5);
        n3.setLeft(n6); n3.setRight(n7);
        n4.setLeft(n8);

        BinaryTree t = new BinaryTree();
        t.setRoot(n1);

        System.out.print("트리 노드 수 = "+ t.size(t.getRoot())+"\n트리 높이 = "+ t.height(t.getRoot()));
        System.out.printf("\n전위 순회: ");
        t.preorder(t.getRoot());
        System.out.printf("\n중위 순회: ");
        t.inorder(t.getRoot());
        System.out.printf("\n후위 순회: ");
        t.postorder(t.getRoot());
        System.out.printf("\n레벨 순회: ");
        t.levelorder(t.getRoot());
        System.out.println();

        Node n10 = new Node(100,null,null); Node n20 = new Node(200,null,null);
        Node n30 = new Node(300,null,null); Node n40 = new Node(400,null,null);
        Node n50 = new Node(500,null,null); Node n60 = new Node(600,null,null);
        Node n70 = new Node(700,null,null); Node n80 = new Node(800,null,null);

        n10.setLeft(n20); n10.setRight(n30);
        n20.setLeft(n40); n20.setRight(n50);
        n30.setLeft(n60); n30.setRight(n70);
        n40.setLeft(n80);

        BinaryTree t2 = new BinaryTree();
        t2.setRoot(n10);

        System.out.print("동일성 검사: "+BinaryTree.isEqual(t.getRoot(), t2.getRoot()));
    }
}
