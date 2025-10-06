package stacks.week6.example3;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value>{
    public Node root;
    public Node getRoot() { return root; }
    public BST(Key newId, Value newName){
        root = new Node(newId, newName);
    }

    public Value get(Key k) {return get(root, k);}
    public Value get(Node n, Key k) {
        if (n == null) return null;
        int t = n.getKey().compareTo(k);
        if (t > 0) return get(n.getLeft(), k);
        else if (t < 0) return get(n.getRight(), k);
        else return (Value) n.getValue();
    }

    public void put(Key k, Value v) {root = put(root, k, v);}
    public Node put(Node n, Key k, Value v){
        if (n == null) return new Node(k, v);
        int t = n.getKey().compareTo(k);
        if (t > 0) n.setLeft(put(n.getLeft(), k, v));
        else if (t < 0) n.setRight(put(n.getRight(), k, v));
        else n.setValue(v);
        return n;
    }

    public Key min() {
        if (root == null) return null;
        return (Key) min(root).getKey();}
    private Node min(Node n) {
        if (n.getLeft() == null) return n;
        return min(n.getLeft());
    }

    public void deleteMin() {
        if (root == null) System.out.println("empty 트리");
        root = deleteMin(root);}
    public Node deleteMin(Node n) {
        if (n.getLeft() == null) return n.getRight();
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    public void delete(Key k) {root = delete(root, k);}
    public Node delete(Node n, Key k) {
        if (n==null) return null;
        int t = n.getKey().compareTo(k);
        if (t > 0) n.setLeft(delete(n.getLeft(), k));
        else if (t < 0) n.setRight(delete(n.getRight(), k));
        else {
            if (n.getRight() == null) return n.getLeft();
            if (n.getLeft() == null) return n.getRight();
            Node target = n;
            n = min(target.getRight());
            n.setRight( deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }
        return n;
    }

    public int height() {return height(root)+1;}
    private int height(Node n) {
        if (n == null) return -1;
        return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
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
            inorder(n.getLeft());
            System.out.print(n.getKey()+" ");
            inorder(n.getRight());
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

    public void preorder(Node n) {
        if (n != null) {
            System.out.print(n.getKey()+" ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public static void main(String[] args) {
        BST t = new BST(500, "Apple");

        t.put(600, "Banana"); t.put(200, "Melon"); t.put(100, "Orange");
        t.put(400, "Tangerine"); t.put(250, "Kiwi"); t.put(150, "Grape");
        t.put(800, "Strawberry");t.put(700, "Cherry"); t.put(50, "Pear");
        t.put(350, "Lemon"); t.put(10, "Watermelon");t.print(t.root);

        System.out.println("\n높이 = "+ t.height());

        System.out.printf("\n200과 400 삭제 후:");
        t.delete(200); t.delete(400); t.print(t.root);
    }
}