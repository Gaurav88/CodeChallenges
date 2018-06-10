import java.util.*;

public class CodeGladiatorSemi2018_2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int N = sc.nextInt();
        Tree arr[] = new Tree[N];
        double dLimit = sc.nextDouble();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int countOfMonkey = sc.nextInt();
            int theshold = sc.nextInt();
            Tree tree = new Tree(x, y, countOfMonkey, theshold);
            arr[i] = tree;
            if (countOfMonkey > theshold) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println(-1);
        } else {
            List<Integer> list = countTrees(arr, dLimit);
            if (list == null || list.size() == 0) {
                System.out.println(-1);
            } else {
                for (int i : list) {
                    System.out.print(i + " ");
                }
            }
        }

    }

    private static List<Integer> countTrees(Tree[] arr, double dLimit) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = 0;
            for (; j < arr.length; j++) {
                if (j == i) {
                    continue;
                }
                if (getDistance(arr[i], arr[j]) > dLimit || arr[j].countOfMonkey > arr[j].threshold) {
                    break;
                }
            }
            if (j == arr.length) {
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }

    private static double getDistance(Tree t1, Tree t2) {
        int ycoord = Math.abs(t1.y - t2.y);
        int xcoord = Math.abs(t1.x - t2.x);
        double distance = Math.sqrt((ycoord) * (ycoord) + (xcoord) * (xcoord));
        return distance;
    }

}

class Tree {
    int x;
    int y;
    int countOfMonkey;
    int threshold;

    public Tree(int x, int y, int countOfMonkey, int threshold) {
        this.x = x;
        this.y = y;
        this.countOfMonkey = countOfMonkey;
        this.threshold = threshold;
    }
}
