import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class GoogleCodeJam1 {
    private static FastScanner s = new FastScanner();

    public static void main(String[] args) {
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int D = s.nextInt();
            String P = s.next();
            StringBuilder str = new StringBuilder(P);
            int damage = calcDamage(str);
            int count = i + 1;
            if (damage <= D) {
                System.out.println("Case #" + count + ": " + 0);
            } else {
                int res = hackSystem(str, D);
                if (res == -1) {
                    System.out.println("Case #" + count + ": IMPOSSIBLE");
                } else {
                    System.out.println("Case #" + count + ": " + res);
                }
            }
        }
    }

    private static int calcDamage(StringBuilder str) {
        int power = 1;
        int damage = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'S') {
                damage += power;
            }
            if (str.charAt(i) == 'C') {
                power = power * 2;
            }
        }
        return damage;
    }

    private static int hackSystem(StringBuilder str, int damage) {
        int count = 0;
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == 'S' && str.charAt(i - 1) == 'C') {
                count++;
                str.setCharAt(i, 'C');
                str.setCharAt(i - 1, 'S');
                int res = calcDamage(str);
                if (res <= damage) {
                    return count;
                }
                i = str.length();
            }


        }
        return -1;
    }
}

class FastScanner {
    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
        if (ptr < buflen) {
            return true;
        } else {
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (buflen <= 0) {
                return false;
            }
        }
        return true;
    }

    private int readByte() {
        if (hasNextByte()) return buffer[ptr++];
        else return -1;
    }

    private static boolean isPrintableChar(int c) {
        return 33 <= c && c <= 126;
    }

    private void skipUnprintable() {
        while (hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;
    }

    public boolean hasNext() {
        skipUnprintable();
        return hasNextByte();
    }

    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}