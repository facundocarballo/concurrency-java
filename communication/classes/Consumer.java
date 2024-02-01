package communication.classes;

public class Consumer implements Runnable {
    Mail mail;

    public Consumer(Mail mail) {
        this.mail = mail;
    }

    private void printMessage(String msg) {
        System.out.println("[Consumer]: " + msg);
    }

    @Override
    public void run() {
        String msg;
        while (true) {
            msg = mail.receiveMessage();
            this.printMessage(msg + " received.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
