public class Waiter {
    Semaphore[] forks;
    int philosopherCount;
    int philosophersPickedUp;
    public Waiter (int philosopherCount) {
        this.philosopherCount = philosopherCount;
        this.forks = new Semaphore[this.philosopherCount];
        this.philosophersPickedUp = 0;
    }
    public void produceForks() {
        for (int i = 0; i < this.philosopherCount; i++) {
            this.forks[i] = new Semaphore(1);
        }
    }
    public void pickUp(int index) {
        if (philosophersPickedUp <= this.philosopherCount - 1) {
            this.forks[index].P();
            this.philosophersPickedUp++;
        }
    }
    public void putDown(int index) {
        this.philosophersPickedUp--;
        this.forks[index].V();
    }
}
