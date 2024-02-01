package synchronization.classes;

public class C implements Runnable {
    private A a;

    public C(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            a.increment();
        }
    }
}
