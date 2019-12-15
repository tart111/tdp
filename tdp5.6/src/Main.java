import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    static void reverse(byte a[])
    {
        int i, k;
        byte t;
        for (i = 0; i < a.length / 2; i++) {
            t = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = t;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter your line");
        Scanner sc = new Scanner(System.in);
        String phrase = sc.nextLine();
        try {
            byte[] line = phrase.getBytes("UTF-8");
            reverse(line);
            String p = new String(line, "UTF-8");
            System.out.println(p);
        }
        catch (UnsupportedEncodingException e){e.printStackTrace();}
    }
}
