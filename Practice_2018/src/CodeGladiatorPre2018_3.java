
import java.util.*;

public class CodeGladiatorPre2018_3 {

    static int max = 0;

    public static void main(String[] args)  throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        LinkedList<Integer> adj[] = new LinkedList[N + 1];
        for (int i = 0; i <= N; ++i)
            adj[i] = new LinkedList();
        for (int i = 1; i < N; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            add_edge(adj,num1,num2);
        }

        for (int i = 0; i < M; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
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
            //System.out.println("Given source and destination are not connected");
            return;
        }

        int crawl = dest;
        hMap.get(crawl).giftCount++;
        if (hMap.get(crawl).giftCount > max) {
            max = hMap.get(crawl).giftCount;
        }

        while (pred[crawl] != -1) {
            hMap.get(pred[crawl]).giftCount++;
            if (hMap.get(pred[crawl]).giftCount > max) {
                max = hMap.get(pred[crawl]).giftCount;
            }
            crawl = pred[crawl];
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

        adj[src].add(dest);
        adj[dest].add(src);
    }
}



