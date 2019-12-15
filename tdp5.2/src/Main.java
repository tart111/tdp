import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int min = 1;
        int max = 200;
        int n = 150;
        int select = 15;
        ArrayList<Integer> alpha = new ArrayList<>();
        for (int i = 0; i <n; i++){
            alpha.add((int)(Math.random()*((max-min)+1))+min);
        }


        ArrayList<Integer> alphaCopy = new ArrayList<>(alpha);

        Collections.sort(alphaCopy, Collections.reverseOrder());


        ArrayList<Integer> beta = new ArrayList<>(select);
        for (int i = 0; i< select; i++){
            beta.add(alphaCopy.get(i));
        }

        System.out.println(beta);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("tdp5"))){
            writer.write(beta.toString());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}