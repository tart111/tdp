import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("Info.txt");
            Scanner sc = new Scanner(file);
            ArrayList<String> wordList = new ArrayList<>();
            while (sc.hasNext()){
                wordList.add(sc.next());
            }
            wordList.sort(new AlphabetComparator());
            for (int k = 0; k < wordList.size(); k++)
                System.out.println(wordList.get(k));

        }
        catch (Exception e) {System.out.println(e);}
    }
}
