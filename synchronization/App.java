package synchronization;
import synchronization.classes.A;
import synchronization.classes.B;
import synchronization.classes.C;

public class App {

    public static void main(String[] args) {
        int result = 20;
        long tiempoInicio = System.currentTimeMillis();

        while (result == 20) {
            A a = new A();
            Thread threadB = new Thread(new B(a));
            Thread threadC = new Thread(new C(a));
            threadB.start();
            threadC.start();

            try {
                threadB.join();
                threadC.join();
                result = a.getNumber();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        long tiempoFin = System.currentTimeMillis();
        System.out.println("Resultado != 20 ====> " + result);
        System.out.println("Tiempo: " + (tiempoFin - tiempoInicio) / 1000 + " segundos.");
    }
}