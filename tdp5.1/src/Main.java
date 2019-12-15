import java.util.*;

public class Main {

    private static Random rand = new Random();

    private static <Collection extends AbstractCollection<Integer>> void fillValues(Collection collection) {
        int initialSize = 10000;
        for (int i = 0; i < initialSize; i++) collection.add(rand.nextInt());
    }


    private static <Collection extends AbstractCollection<Integer>> long addTime(Collection collection) {

        fillValues(collection);

        // measure time needed to append elements
        int checkAmount = 1000;

        ArrayList<Integer> elementsToAdd = new ArrayList<>();

        for (int i = 0; i < checkAmount; i++) {
            elementsToAdd.add(rand.nextInt());
        }

        long startTime = System.nanoTime();
        collection.addAll(elementsToAdd);
        long averageTime = (System.nanoTime() - startTime) / checkAmount;

        collection.clear();
        return averageTime;
    }

    private static <Collection extends AbstractCollection<Integer>> Integer getElementByIndex(Collection collection, int ind) {
        Iterator<Integer> iterator = collection.iterator();
        for (int i = 0; i < ind; i++) iterator.next();
        return iterator.next();
    }

    private static <Collection extends AbstractCollection<Integer>> ArrayList<Integer> getRandomElements(Collection collection, int amount) {

        // measure time needed to append elements
        int size = collection.size();

        ArrayList<Integer> randomElements = new ArrayList<>();
        for (int i = 0; i < amount; i++) randomElements.add(getElementByIndex(collection, rand.nextInt(size)));

        return randomElements;
    }

    private static <Collection extends AbstractCollection<Integer>> long searchTime(Collection collection) {

        fillValues(collection);

        // measure time needed to remove elements
        int checkAmount = 1000;

        ArrayList<Integer> elementsToSearch = getRandomElements(collection, checkAmount);

        long totalTime = 0;

        for (Integer elemToSearch: elementsToSearch) {
            Iterator<Integer> iterator = collection.iterator();

            long startTime = System.nanoTime();
            while (!elemToSearch.equals(iterator.next())) {}
            totalTime += System.nanoTime() - startTime;
        }
        collection.clear();
        return totalTime / checkAmount;
    }

    private static <Collection extends AbstractCollection<Integer>> long removeTime(Collection collection) {

        fillValues(collection);

        // measure time needed to remove elements
        int checkAmount = 1000;

        ArrayList<Integer> elementsToRemove = getRandomElements(collection, checkAmount);

        long startTime = System.nanoTime();
        collection.removeAll(elementsToRemove);
        long averageTime = (System.nanoTime() - startTime) / checkAmount;
        collection.clear();
        return averageTime;
    }

    private static <Collection extends AbstractCollection<Integer>> void timeResults(Collection collection) {
        System.out.println("\n" + collection.getClass().getName() + ":");
        System.out.println("\tAdd: " + addTime(collection) + " nanosec");
        System.out.println("\tSearch: " + searchTime(collection) + " nanosec");
        System.out.println("\tRemove: " + removeTime(collection) + " nanosec");
    }


    public static void main(String[] args) {
        timeResults(new LinkedList<>());
        timeResults(new ArrayList<>());
        timeResults(new TreeSet<>());
        timeResults(new HashSet<>());


    }
}

