public class CeasarCipher {

    public static void main(String[] args) {
        String str = "CCZxghUIz";
        int key = 5;
        String encoded = cipher(str, key);
        System.out.println("Encrypted: " + encoded);
        System.out.println("Decrypted: " + decoder(encoded, key));
    }

    public static String cipher(String str, int key) {
        StringBuffer output = new StringBuffer();

        int i = 0;
        while (i < str.length()) {
            if (Character.isUpperCase(str.charAt(i))) {
                char ch = (char) ((str.charAt(i) + key - 65) % 26 + 65);
                output.append(ch);
            } else {
                char ch = (char) ((str.charAt(i) + key - 97) % 26 + 97);
                output.append(ch);
            }
            i++;
        }
        return output.toString();
    }

    public static StringBuffer decoder(String cipher, int key) {
        StringBuffer output = new StringBuffer();

        int i = 0;
        while (i < cipher.length()) {
            if (Character.isUpperCase(cipher.charAt(i))) {
                char ch = (char) ((cipher.charAt(i) + 26 - key - 65) % 26 + 65);
                output.append(ch);
            } else {
                char ch = (char) ((cipher.charAt(i) + 26 - key - 97) % 26 + 97);
                output.append(ch);
            }
            i++;
        }
        return output;
    }


}
