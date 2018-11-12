import javax.sound.midi.SysexMessage;

public class Philosopher extends Thread {
    int index;
    Waiter waiter;
    int philosopherCount;
    public Philosopher(int index, Waiter waiter, int philosopherCount) {
        this.index = index;
        this.waiter = waiter;
        this.philosopherCount = philosopherCount;
    }
    public void run() {
        int nextIndex = (this.index + 1) % this.philosopherCount;
        while(true) {
            System.out.println("Philosopher " + this.index + " is thinking...");
            try {
                sleep((int) (Math.random() * 300));
            } catch (InterruptedException e) {

            }
            this.waiter.pickUp(this.index);
            System.out.println("Philosopher " + this.index + " is picking a fork " + this.index + " up");
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {

            }
            this.waiter.pickUp(nextIndex);
            System.out.println("Philosopher " + this.index + " is picking a fork " + nextIndex + " up");

            System.out.println("Philosopher " + this.index + " is eating...");

            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {

            }

            System.out.println("Philosopher " + this.index + " is putting a fork " + nextIndex + " down");
            this.waiter.putDown(nextIndex);
            System.out.println("Philosopher " + this.index + " is putting a fork " + this.index + " down");
            this.waiter.putDown(this.index);

        }
    }
}
