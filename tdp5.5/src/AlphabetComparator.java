import java.util.Comparator;

public class AlphabetComparator implements Comparator<String> {
    public int compare (String a, String b){
        return (a.toLowerCase()).compareTo(b.toLowerCase());
    }
}
