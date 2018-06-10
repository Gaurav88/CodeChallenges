import java.util.*;

//Perfect
public class CodeGladiatorPre2018_1 {

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Graph g = new Graph(N);
        int root = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == -1) {
                root = i;
            } else {
                g.addEdge(num, i);
            }
        }
        int node = sc.nextInt();
        if (node == root) {
            System.out.println(0);
        } else {
            g.removeEdge(root, node);
            int res = g.BFSLeaf(root);
            System.out.println(res);
        }
    }*/

}

/*
class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v + 1];
        for (int i = 0; i <= v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void removeEdge(int root, int v) {
        int res = BFS(root, v);
        List list = adj[res];

        list.remove(new Integer(v));
    }

    // prints BFS traversal from a given source s
    int BFS(int s, int node) {

        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    if (n == node) {
                        return s;
                    }
                }
            }
        }
        return s;
    }

    int BFSLeaf(int s) {
        int count = 0;
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();

            Iterator<Integer> i = adj[s].listIterator();
            if (!i.hasNext()) {
                count++;
            }
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return count;
    }
}*/
