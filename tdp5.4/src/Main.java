import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int input(int a, int b){
        int i = 0;
        boolean flag = true;
        while (flag) {
            try {
                Scanner sc = new Scanner(System.in);
                i = sc.nextInt();
                if ((i >=a) && (i <=b)) flag = false;
                else  System.out.println("Number is not in range");
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println("Try to guess the number");
        Random rand = new Random();
        int n;
        int inf = 0;
        int sup = 100;
        int number = rand.nextInt(sup-inf+1)+inf;
        int guess = input(inf, sup);
        while (guess != number){
            if ((guess-number) > 0) {
                inf = (int)(rand.nextInt(number-inf+1)*0.7) + inf;
                sup = guess;
                System.out.println(String.format("Lower, hint: the number is in range [%d;%d]", inf, sup));
            }
            else{
                n = (int)(rand.nextInt(sup-number+1)*1.3) + number;
                if (n  < sup){
                    sup = n;
                }
                inf = guess;
                System.out.println(String.format("Higher, hint: the number is in range [%d;%d]", inf, sup));
            }
            guess = input(inf, sup);
        }
        System.out.println(" _|      _|                                                                _|  ");
        System.out.println("   _|  _|    _|_|    _|    _|      _|      _|      _|    _|_|    _|_|_|    _|  ");
        System.out.println("     _|    _|    _|  _|    _|      _|      _|      _|  _|    _|  _|    _|  _|  ");
        System.out.println("     _|    _|    _|  _|    _|        _|  _|  _|  _|    _|    _|  _|    _|      ");
        System.out.println("     _|      _|_|      _|_|_|          _|      _|        _|_|    _|    _|  _|  ");


    }
}
