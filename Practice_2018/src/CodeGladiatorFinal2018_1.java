import java.util.*;

public class CodeGladiatorFinal2018_1 {
    private Stack<String> path = new Stack<String>();   // the current path
    private Set<String> onPath = new HashSet<String>();
    private static List<List<String>> allPath = new ArrayList<>();
    private static List<List<String>> finalPath = new ArrayList<>();

    public CodeGladiatorFinal2018_1(Graph G, String s, String t) {
        enumerate(G, s, t, true);
    }

    // use DFS
    private void enumerate(Graph G, String v, String t, boolean flag) {

        path.push(v);
        onPath.add(v);

        if (v.equals(t) && flag) {
            flag = false;
            //path = new Stack<String>();
            onPath = new HashSet<String>();
        } else if (v.equals(t) && !flag) {
            List<String> list = new ArrayList<>();
            for (String s : path) {
                list.add(s);
            }
            allPath.add(list);
            //System.out.println(path);
        }

        for (String w : G.adjacentTo(v)) {
            if (!onPath.contains(w)) enumerate(G, w, t, flag);
        }

        path.pop();
        onPath.remove(v);
    }

    public static void main(String[] args) throws Exception {
        Graph G = new Graph();
        Map<MapNode, Integer> tort = new HashMap<>();
        Map<MapNode, Integer> hare = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            G.addEdge(String.valueOf(u - 1), String.valueOf(v - 1));
            int to = sc.nextInt();
            int ha = sc.nextInt();
            tort.put(new MapNode(u - 1, v - 1), to);
            hare.put(new MapNode(u - 1, v - 1), ha);
        }

        //System.out.println(G);
        for (int i = 0; i < N; i++) {
            new CodeGladiatorFinal2018_1(G, String.valueOf(i), String.valueOf(i));
            for (List list : allPath) {
                if (!finalPath.isEmpty() && list.size() < finalPath.get(0).size()) {
                    finalPath = new ArrayList<>();
                    finalPath.add(list);
                } else if (!finalPath.isEmpty() && list.size() == finalPath.get(0).size()) {
                    finalPath.add(list);
                } else if (finalPath.isEmpty()) {
                    finalPath.add(list);
                }
                allPath = new ArrayList<>();
            }
        }
        long res = 0;
        for (List<String> list : finalPath) {
            int temp = Integer.parseInt(list.get(0));
            long hTime = 0;
            long tTime = 0;
            for (int i = 1; i < list.size(); i++) {
                int val = Integer.parseInt(list.get(i));
                MapNode node = new MapNode(temp, val);
                hTime += hare.get(node);
                tTime += tort.get(node);
                temp = val;
            }
            long calc = hTime - tTime;
            if (calc > res) {
                res = calc;
            }
        }
        System.out.println(finalPath.get(0).size() - 1 + " " + res);

    }
}

class Graph {

    private Map<String, Set<String>> st;

    Graph() {

        st = new HashMap<String, Set<String>>();
    }

    public void addEdge(String v, String w) {
        if (!hasVertex(v)) addVertex(v);

        st.get(v).add(w);
    }

    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new HashSet<String>());
    }

    public boolean hasVertex(String v) {
        return st.containsKey(v);
    }

    public Iterable<String> adjacentTo(String v) {
        if(st.containsKey(v)){
            return st.get(v);
        }
        else{
            return new LinkedList<>();
        }
        //return st.get(v);
    }
}

class MapNode {
    int u;
    int v;

    public MapNode(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapNode mapNode = (MapNode) o;

        if (u != mapNode.u) return false;
        return v == mapNode.v;
    }

    @Override
    public int hashCode() {
        int result = u;
        result = 31 * result + v;
        return result;
    }
}

