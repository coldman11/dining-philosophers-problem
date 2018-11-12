public class DiningPhilosophers {
    int philosopherCount;
    Semaphore[] forks;
    Waiter waiter;

    public DiningPhilosophers(int philosopherCount) {
        this.philosopherCount = philosopherCount;
        this.forks = new Semaphore[philosopherCount];
        this.waiter = new Waiter(philosopherCount);
    }

    public void execute() {
        this.waiter.produceForks();
        int i;
        for (i = 0; i < this.philosopherCount; i++) {
            Thread philosopher = new Philosopher(i, this.waiter, this.philosopherCount);
            philosopher.start();
        }
    }
}
