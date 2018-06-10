import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vmware {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //List<Rectangle>[][] rectArr = new List[20000][20000];
        int[][] temp = new int[2000][2000];
        int N = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        List<Rectangle> arr = new ArrayList();
        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int c = sc.nextInt();
            Rectangle rect = new Rectangle(x1, y1, x2, y2, c);
            arr.add(rect);
            intializeRect(rect, temp);
        }
        int sum = 0;
        /*for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Rectangle rect1 = arr.get(i);
                Rectangle rect2 = arr.get(j);
                int res = overlappingArea(rect1.x1, rect1.y1, rect1.x2, rect1.y2, rect2.x1, rect2.y1, rect2.x2, rect2.y2);
                sum = sum + res * rect1.cost + res * rect2.cost;
            }
        }*/
        System.out.println(sum);
    }

    private static void intializeRect(Rectangle r1, int arr[][]) {
        for (int i = r1.x1; i < r1.x2; i++) {
            arr[i][r1.y1]++;
        }
        for (int i = r1.y1 + 1; i <= r1.y2; i++) {
            arr[r1.x1][i]++;
        }
        for (int i = r1.x1 + 1; i <= r1.x2; i++) {
            arr[i][r1.y2]++;
        }
        for (int i = r1.y2; i < r1.y2; i++) {
            arr[r1.x2][i]++;
        }
    }

    /*private static int overlappingArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int x5 = Math.max(x1, x3);
        int y5 = Math.max(y1, y3);
        int x6 = Math.min(x2, x4);
        int y6 = Math.min(y2, y4);

        int len = Math.abs(x5 - x6) + 1;
        int wid = Math.abs(y5 - y6) + 1;

        return len * wid;
    }*/
}

class Rectangle {
    int x1;
    int y1;
    int x2;
    int y2;
    int cost;

    public Rectangle(int x1, int y1, int x2, int y2, int cost) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cost = cost;
    }
}
