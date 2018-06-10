public class SamsungTechgigFeb18 {
    public static int cadbury(int input1, int input2, int input3, int input4) {
        int res = 0;
        if (input2 >= input1 && input4 >= input3 && input1 > 0 && input2 > 0
                && input3 > 0 && input4 > 0) {
            for (int row = input1; row <= input2; row++) {
                for (int column = input3; column <= input4; column++) {
                    int rowLeft = row, columnLeft = column;
                    while (true) {
                        if (rowLeft == 0 && columnLeft == 0) {
                            break;
                        }
                        if (rowLeft > columnLeft) {
                            rowLeft = rowLeft - columnLeft;
                            res = res + 1;
                        }
                        if (rowLeft < columnLeft) {
                            columnLeft = columnLeft - rowLeft;
                            res = res + 1;
                        }
                        if (rowLeft == columnLeft) {
                            rowLeft = 0;
                            columnLeft = 0;
                            res = res + 1;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = cadbury(5,6,3,4);
        System.out.println(res);
    }

}
