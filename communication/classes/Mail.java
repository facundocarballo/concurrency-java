package communication.classes;

import java.util.LinkedList;
import java.util.Queue;

public class Mail {
    private Queue<String> messages = new LinkedList<>();
    private final int MAX_MESSAGES;

    public Mail(int max_messages) {
        this.MAX_MESSAGES = max_messages;
    }

    public synchronized boolean sendMessage(String msg) {
        while (messages.size() == MAX_MESSAGES) {
            try {
                System.out.println("Waiting, mail is full...");
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            messages.add(msg);
            notify();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }

    public synchronized String receiveMessage() {
        while (messages.isEmpty()) {
            try {
                System.out.println("Waiting for messages...");
                wait();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            return messages.poll();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    
}
