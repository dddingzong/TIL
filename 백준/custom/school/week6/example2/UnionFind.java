package stacks.week6.example2;

public class UnionFind {
    protected Node[] a;

    public UnionFind(Node[] iarray) {
        a = iarray;
    }

    protected int find(int i) {
        if ( i != a[i].getParent())
            a[i].setParent(find(a[i].getParent()));
        return a[i].getParent();
    }

    public void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);
        if (iroot == jroot) return;
        if (a[iroot].getRank() > a[jroot].getRank())
            a[jroot].setParent(iroot);
        else if (a[iroot].getRank() < a[jroot].getRank())
            a[iroot].setParent(jroot);
        else {
            a[jroot].setParent(iroot);
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t);
        }
    }

    public static void main(String[] args) {
        int N = 10;
        Node[] a = new Node[N];

        for (int i = 0; i < N; i++)
            a[i] = new Node(i, 0);

        UnionFind uf = new UnionFind(a);

        uf.union(2, 1); uf.union(2, 6);
        uf.union(7, 3); uf.union(4, 5);
        uf.union(9, 5); uf.union(7, 2);
        uf.union(7, 8); uf.union(0, 4);

        System.out.print("8회의 union 연산 수행 후\n(i:parent,rank):");
        for(int i = 0; i < N; i++)
            System.out.print("("+i+":"+uf.a[i].getParent()+","+uf.a[i].getRank()+") ");

        uf.union(9, 1);
        System.out.print("\n\nunion(9,1) 수행 후\n(i:parent,rank):");
        for(int i = 0; i < N; i++)
            System.out.print("("+i+":"+uf.a[i].getParent()+","+uf.a[i].getRank()+") ");

        uf.union(6, 0);
        System.out.print("\n\nunion(6,0) 수행 후\n(i:parent,rank):");
        for(int i = 0; i < N; i++)
            System.out.print("("+i+":"+uf.a[i].getParent()+","+uf.a[i].getRank()+") ");
        System.out.println();
    }
}