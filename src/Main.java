public class Main {

    public static void main(String[] args) {
        int philosopherCount = 5;
        DiningPhilosophers table = new DiningPhilosophers(philosopherCount);
        table.execute();
    }
}
