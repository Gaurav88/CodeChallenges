import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class CodeGladiatorPre2018_2 {
    //private static Stack<Node> path;   // the current path
    //private static Set<Node> onPath;
    //static NewGraph G;
    //static boolean visited[];
    static int max = 0;
    //static boolean found;

    public static void main(String[] args)  throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        //G = new NewGraph(N);
        LinkedList<Integer> adj[] = new LinkedList[N + 1];
        for (int i = 0; i <= N; ++i)
            adj[i] = new LinkedList();
        for (int i = 1; i < N; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            //G.addEdge(num1, num2);
            add_edge(adj,num1,num2);
        }

        for (int i = 0; i < M; i++) {
            //path = new Stack<>();
            //onPath = new HashSet<>();
            //visited = new boolean[N + 1];
            //found = false;
            int a = sc.nextInt();
            int b = sc.nextInt();
            //enumerate(G.hMap.get(a), b);
            printShortestDistance(adj, a, b, N + 1);
        }
        System.out.println(max);
    }

    static boolean BFS(LinkedList<Integer> adj[], int src, int dest, int v,
                       int pred[], int dist[]) {

        Queue<Integer> queue = new PriorityQueue<>();
        boolean visited[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // standard BFS algorithm
        while (!queue.isEmpty()) {
            int u = queue.peek();
            queue.poll();
            for (int i = 0; i < adj[u].size(); i++) {
                if (visited[adj[u].get(i)] == false) {
                    visited[adj[u].get(i)] = true;
                    dist[adj[u].get(i)] = dist[u] + 1;
                    pred[adj[u].get(i)] = u;
                    queue.add(adj[u].get(i));


                    if (adj[u].get(i) == dest)
                        return true;
                }
            }
        }

        return false;
    }

    static void printShortestDistance(LinkedList<Integer> adj[], int s,
                                      int dest, int v) {

        int pred[] = new int[v];
        int dist[] = new int[v];


        if (BFS(adj, s, dest, v, pred, dist) == false) {
            System.out.println("Given source and destination are not connected");
            return;
        }

        Vector<Node> path = new Vector<>();
        int crawl = dest;
        path.add(hMap.get(crawl));
        while (pred[crawl] != -1) {
            path.add(hMap.get(pred[crawl]));
            crawl = pred[crawl];
        }

        //System.out.println("Shortest path length is : " + dist[dest]);

        //System.out.println("\nPath is::\n");
        for (int i = path.size() - 1; i >= 0; i--) {
            path.get(i).giftCount++;
            if (path.get(i).giftCount > max) {
                max = path.get(i).giftCount;
            }
            //System.out.println(path.get(i).val);
        }
    }

   static Map<Integer, Node> hMap = new HashMap<>();
    static void add_edge(LinkedList<Integer> adj[], int src, int dest) {
        Node n1;
        Node n2;
        if (!hMap.containsKey(src)) {
            n1 = new Node(src, 0);
        } else {
            n1 = hMap.get(src);
        }
        if (!hMap.containsKey(dest)) {
            n2 = new Node(dest, 0);
        } else {
            n2 = hMap.get(dest);
        }
        hMap.put(src, n1);
        hMap.put(dest, n2);
        /*adj[src].add(n2);
        adj[dest].add(n1);*/
        adj[src].add(dest);
        adj[dest].add(src);
    }

    /*private static void enumerate(Node v, int t) {

        path.push(v);
        //onPath.add(v);
        visited[v.val] = true;

        if (v.val == t) {
            found = true;
            List list = new ArrayList();
            for (Node n : path) {
                list.add(n);
                n.giftCount++;
                if (n.giftCount > max) {
                    max = n.giftCount;
                }
            }

        } else {
            for (Node w : G.adjacentTo(v)) {
                if (found) {
                    break;
                }
                if (!path.contains(w) && !visited[w.val]) {
                    enumerate(w, t);
                }
            }
        }

        path.pop();
        //onPath.remove(v);
    }*/
}

class Node implements Comparable<Node> {
    int val;
    int giftCount;

    public Node(int val, int giftCount) {
        this.val = val;
        this.giftCount = giftCount;
    }

    @Override
    public int compareTo(Node o) {
        return o.val - this.val;
    }
}

/*class NewGraph {
    private int V;   // No. of vertices
    LinkedList<Node> adj[]; //Adjacency Lists
    Map<Integer, Node> hMap = new HashMap<>();

    // Constructor
    NewGraph(int v) {
        V = v;
        adj = new LinkedList[v + 1];
        for (int i = 0; i <= v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        Node n1;
        Node n2;
        if (!hMap.containsKey(v)) {
            n1 = new Node(v, 0);
        } else {
            n1 = hMap.get(v);
        }
        if (!hMap.containsKey(w)) {
            n2 = new Node(w, 0);
        } else {
            n2 = hMap.get(w);
        }
        hMap.put(v, n1);
        hMap.put(w, n2);
        adj[v].add(n2);
        adj[w].add(n1);
    }

    public Iterable<Node> adjacentTo(Node v) {
        return adj[v.val];
    }

}*/

