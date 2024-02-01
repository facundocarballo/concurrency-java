package communication.classes;

public class Wait implements Runnable {
    private A a;

    public Wait(A a) {
        this.a = a;
    }

    @Override
    public synchronized void run() {
        try {
            System.out.println("Soy la clase Wait, voy a empezar a esperar.");
            a.waitResource();
            System.out.println("Soy la clase Wait, termine de esperar.");
        } catch (Exception err) {
            System.err.println(err);
        }
    }

}
