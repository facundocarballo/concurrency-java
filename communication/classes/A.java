package communication.classes;

public class A {
    private int number = 0;

    public A() {
    }

    public void waitResource() throws InterruptedException {
        System.out.println("Soy A, hare que la instancia que invoco a este metodo espere hasta que el numero llegue a 10.");
        while (this.number < 10) {
            wait();
        }
        System.out.println("Soy A, llego a 10!!!");

    }

    public int getNumber() {
        return this.number;
    }

    public synchronized void increment() {
        this.number++;
        if (this.number == 10) {
            System.out.println("Soy A, llegamos a 10, vamos a notificar al otro hilo.");
            notify();
        }
    }
}
