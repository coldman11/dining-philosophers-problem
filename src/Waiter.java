import java.util.ArrayList;

public class Waiter {
    Semaphore[] forks;
    int philosopherCount;
    private ArrayList philosophers = new ArrayList();
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

        if (this.philosophers.size() <= this.philosopherCount - 1) {
            this.forks[index].P();
            if (!this.philosophers.contains(index)) {
                this.philosophers.add(index);
                this.philosophersPickedUp = this.philosophers.size();
            }
        }
    }
    public void putDown(int index) {
        this.forks[index].V();
        if (this.philosophers.contains(index)) {
            this.philosophers.remove(this.philosophers.indexOf(index));
        }
        this.philosophersPickedUp = this.philosophers.size();
    }
}
