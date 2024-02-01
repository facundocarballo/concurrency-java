package communication;

import communication.classes.A;
import communication.classes.Consumer;
import communication.classes.Mail;
import communication.classes.Notify;
import communication.classes.Producer;
import communication.classes.Wait;

public class App {

    private static void firstMethod() {
        A a = new A();
        Thread waitThread = new Thread(new Wait(a));
        Thread notifyThread = new Thread(new Notify(a));

        waitThread.start();
        notifyThread.start();

        try {
            waitThread.join();
            notifyThread.join();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    private static void producerConsumer() {
        Mail mail = new Mail(5);
        Thread producerThread = new Thread(new Producer(mail));
        Thread consumerThread = new Thread(new Consumer(mail));

        consumerThread.start();
        producerThread.start();

        try {
            consumerThread.join();
            producerThread.join();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        producerConsumer();
    }
}
