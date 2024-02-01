package synchronization.classes;

public class B implements Runnable {
    private A a;

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            a.increment();
        }
    }
}
