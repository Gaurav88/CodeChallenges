import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\BACKUP\\Softwares\\garena.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int count = 0;
        while ((st = br.readLine()) != null) {
            String[] word = st.trim().split("\t");
            for (String str : word) {
                String[] temp = str.split(" ");
                for (String s : temp) {
                    if (s.trim().length() > 0) {
                        System.out.println(s);
                        count++;
                    }
                }
            }

        }
        System.out.println(count);
    }
}


