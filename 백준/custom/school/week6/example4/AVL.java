package stacks.week6.example4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVL<Key extends Comparable<Key>, Value> {
    private Node root;
    
    public class Node {
        private Key id;
        private Value name;
        private int height;
        private Node left, right;
        
        public Node(Key newID, Value newName, int newHt) {
            id = newID;
            name = newName;
            height = newHt;
            left = right = null;
        }
    }

    private int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    public void put(Key k, Value v) {root = put(root, k, v);}
    private Node put(Node n, Key k, Value v) {
        if (n == null) return new Node(k, v, 1);
        int t = k.compareTo(n.id);
        if (t < 0) n.left = put(n.left, k, v);
        else if (t > 0) n.right = put(n.right, k, v);
        else {
            n.name = v;
            return n;
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n);
    }

    private Node balance(Node n) {
        if (bf(n) > 1) {
            if (bf(n.left) < 0) {
                n.left = rotateLeft(n.left);
            }
            n = rotateRight(n);
        }
        else if (bf(n) < -1) {
            if (bf(n.right) > 0) {
                n.right = rotateRight(n.right);
            }
            n = rotateLeft(n);
        }
        return n;
    }

    private int bf(Node n) {
        return height(n.left) - height(n.right);
    }

    private Node rotateRight(Node n) {
        Node x = n.left;
        n.left = x.right;
        x.right = n;
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node rotateLeft(Node n) {
        Node x = n.right;
        n.right = x.left;
        x.left = n;
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;
        return x;
    }

    private int tallerHeight(int x, int y){
        if (x>y) return x;
        else return y;
    }

    public Key min() {return min(root).id;}
    private Node min(Node n) {
        if (n.left == null) return n;
        return min(n.left);
    }

    public void deleteMin() {root = deleteMin(root);}
    private Node deleteMin(Node n) {
        if (n.left == null) return n.right;
        n.left = deleteMin(n.left);
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n);
    }

    public void delete(Key k) { root = delete(root, k);}
    private Node delete(Node n, Key k) {
        int t = k.compareTo(n.id);
        if (t < 0) n.left = delete(n.left, k);
        else if (t > 0) n.right = delete(n.right, k);
        else {
            if (n.left == null) return n.right;
            else if (n.right == null) return n.left;
            else {
                Node y = n;
                n = min(y.right);
                n.right = deleteMin(y.right);
                n.left = y.left;
            }
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n);
    }

    public void print(Node root) {
        System.out.printf("\ninorder:\n");
        inorder(root);
        System.out.printf("\npreorder:\n");
        preorder(root);
        System.out.printf("\nlevel order:\n");
        levelorder(root);
    }

    public void inorder(Node n){
        if (n != null) {
            inorder(n.left);
            System.out.print(n.id+" ");
            inorder(n.right);
        }
    }

    public void levelorder(Node root) {
        Queue<Node> q = new LinkedList<Node>();
        Node t;
        q.add(root);
        while (!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.id+" ");
            if (t.left != null)
                q.add(t.left);
            if (t.right != null)
                q.add(t.right);
        }
    }

    public void preorder(Node n) {
        if (n != null) {
            System.out.print(n.id+" ");
            preorder(n.left);
            preorder(n.right);
        }
    }

    public static void main(String[] args) {
        AVL<Integer, String> st = new AVL<Integer, String>();

        st.put(75, "Apple"); st.put(80, "Grape"); st.put(85, "Lime");
        st.put(20, "Mango"); st.put(10, "Strawberry");st.put(50, "Banana");
        st.put(30, "Cherry");st.put(40, "Watermelon");st.put(70, "Melon");
        st.put(90, "fruit"); st.print(st.root);

        System.out.printf("\n\n75와 85 삭제 후:");
        st.delete(75); st.delete(85); st.print(st.root);
    }
}