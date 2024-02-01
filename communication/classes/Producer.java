package communication.classes;

public class Producer implements Runnable {
    Mail mail;

    public Producer(Mail mail) {
        this.mail = mail;
    }

    private void printMessage(String msg) {
        System.out.println("[Producer]: " + msg);
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            mail.sendMessage("Message #" + i);
            i++;
            this.printMessage("Message #" + i + " sended.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
