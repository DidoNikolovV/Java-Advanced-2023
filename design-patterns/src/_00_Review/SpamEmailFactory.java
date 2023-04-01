package _00_Review;

import java.util.Date;

public class SpamEmailFactory implements MessageFactory{
    private String messageSubject;
    private String messageContent;

    public SpamEmailFactory(String messageSubject, String messageContent) {
        this.messageSubject = messageSubject;
        this.messageContent = messageContent;
    }
    @Override
    public Message createMessage(String address, Date date) {
        return Email.builder()
                .addTo(address)
                .setSubject(messageSubject)
                .setText("Happy " + date + "! " + messageContent)
                .build();
    }
}
