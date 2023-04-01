package _00_Review;

import java.util.Date;
import java.util.List;

public class SpamSender {

    private List<String> recipients;
    private MessageFactory messageFactory;

    public SpamSender(List<String> recipients, MessageFactory messageFactory) {
        this.recipients = recipients;
        this.messageFactory = messageFactory;
    }

    public void send() {
        Logger.get().writeMessage("executing send()");
        for (String address : recipients) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                // nop;
            }

            Message message = createMessage(address, new Date());
            sendMessage(message);
        }
    }

    private void sendMessage(Message message) {
        Logger.get().writeMessage("executing sendMessage to " + message.getTo());
        System.out.println("sent mesage");
        System.out.println("\tto: " + message.getTo());
        System.out.println("\tcontent: " + message.getContent());
    }

    private Message createMessage(String address, Date date) {
        Logger.get().writeMessage("executing createMessage:" + address + "," + date);
        return messageFactory.createMessage(address, date);
    }
}
