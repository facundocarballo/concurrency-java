package synchronization.classes;

public class A {
    private int number;

    public A() {
        this.number = 0;
    }

    public int getNumber() {
        return this.number;
    }

    // To make this method atomic, we have to use the keyword 'synchronized'
    // public synchronized
    public synchronized void increment() {
        this.number++;
    }

    public void reset() {
        this.number = 0;
    }
}
