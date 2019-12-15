import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static abstract class Worker{
        String name;
        int id;

        Worker setName(String n){
            name = n;
            return this;
        }

        String getName(){
            return name;
        }

        Worker setID(int i){
            id = i;
            return this;
        }

        int getID(){
            return id;
        }

        abstract double calculateSalary();

        abstract String toFileString();

        public String toString() {
            return String.format("id: %d\tname: %s\tsalary: %f", this.id, this.name, this.calculateSalary());
        }

        public static Worker fromScanner(Scanner sc){
            sc.next();
            String name = new String(sc.next());
            sc.next();
            sc.next();
            int id = sc.nextInt();
            sc.next();
            String type = new String(sc.next());
            double pay = sc.nextDouble();
            if (type.equals("WAGE:")) return new WageWorker(name, id, pay);
            else return new SalaryMan(name, id, pay);
        }
    }

    public static class WageWorker extends Worker{
        double wage;

        @Override
        double calculateSalary() {
            return 20.8*8*wage;
        }

        String toFileString(){
            return String.format("NAME: %s ; ID: %d ; WAGE: %f", name, id, wage);
        }

        WageWorker(){
            name = "Ivan";
            wage = 0;
            id = 0;
        }


        WageWorker(String n, int i, double w){
            name = n;
            wage = w;
            id = i;
        }

        WageWorker(WageWorker w){
            this.name=w.name;
            this.wage=w.wage;
            this.id=w.id;
        }

//        void assign(WageWorker w){
//            this.name=w.name;
//            this.wage=w.wage;
//
//        }

        WageWorker setWage(double w){
            wage = w;
            return this;
        }

        double getWage(){
            return wage;
        }
    }

    public static class SalaryMan extends Worker {
        double salary;

        @Override
        double calculateSalary() {
            return salary;
        }

        String toFileString(){
            return String.format("NAME: %s ; ID: %d ; SALARY: %f", name, id, salary);
        }

        SalaryMan(){
            name = "Ivan";
            salary = 0;
            id = 0;
        }


        SalaryMan(String n, int i, double w){
            name = n;
            salary = w;
            id = i;
        }

        SalaryMan(SalaryMan w){
            this.name=w.name;
            this.salary=w.salary;
            this.id=w.id;
        }

//        void assign(SalaryMan w){
//            this.name=w.name;
//            this.salary=w.salary;
//        }

        SalaryMan setSalary(double s){
            salary = s;
            return this;
        }

        double getSalary(){
            return salary;
        }
    }

    public static class WorkerComparator implements Comparator<Worker>{
        @Override
        public int compare(Worker o1, Worker o2) {
            if (o1.calculateSalary() > o2.calculateSalary()){
                return 1;
            }
            else return o1.calculateSalary() < o2.calculateSalary() ? -1 : o1.getName().compareTo(o2.getName());
        }
    }

    public static void writeWorkers(ArrayList<Worker> workers){
        try {
            PrintWriter writer = new PrintWriter("Result.txt");
            for (int i = 0; i < workers.size(); i++) {
                writer.print("\n" + workers.get(i).toFileString());
            }
            writer.close();
        }
        catch (Exception e){System.out.println(e);}
    }

    public static ArrayList<Worker> readWorkers(){
        ArrayList<Worker> workers = new ArrayList<Worker>();
        try{
        File file = new File("Result.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
        {
            workers.add(Worker.fromScanner(sc));
        }

        }
        catch (Exception e){System.out.println(e);}
        return workers;
    }

    public static void main(String[] args) {
        Worker s = new SalaryMan();

        ArrayList<Worker> workersList = new ArrayList<Worker>();
        workersList.add(new SalaryMan("fff", 10500, 5678));
        workersList.add(new WageWorker("zzz", 29, 7890));
        workersList.add(new SalaryMan("nnn", 20000, 1092));
        workersList.add(new WageWorker("lll", 32, 2763));
        workersList.add(new WageWorker("ppp", 32, 1992));
        workersList.add(new SalaryMan("ccc", 108000, 1072));
        workersList.add(new WageWorker("eee", 55, 8732));
        workersList.add(new WageWorker("qqq", 80, 7924));
        workersList.add(new SalaryMan("aaa", 13000, 7040));

        System.out.println("TASK A:");
        workersList.sort(new WorkerComparator());
        for (int i = 0; i < workersList.size(); i++){
            System.out.println(workersList.get(i).toString());
        }

        System.out.println("_________________________________________");
        System.out.println("TASK B:");
        for (int i = 0; i < 5; i++){
            System.out.println(workersList.get(i).getName());
        }

        System.out.println("_________________________________________");
        System.out.println("TASK C:");
        for (int i = workersList.size()-3; i < workersList.size(); i++){
            System.out.println(workersList.get(i).getID());
        }

        //ArrayList<String> lines = Files.readAllLines(Paths.get("Result.txt"));
        writeWorkers(workersList);
        System.out.println("_________________________________________");
        System.out.println("TASK D:");
        ArrayList<Worker> workers = readWorkers();
        for (int i = 0; i< workers.size(); i++){
            System.out.println(workers.get(i).toFileString());
        }

    }
}
