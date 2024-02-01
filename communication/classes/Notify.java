package communication.classes;

public class Notify implements Runnable {
    private A a;

    public Notify(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            a.increment();
        }
    }
}
