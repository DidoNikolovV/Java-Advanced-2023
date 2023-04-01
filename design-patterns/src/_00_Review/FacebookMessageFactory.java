package _00_Review;

import java.util.Date;

public class FacebookMessageFactory implements MessageFactory{
    private String content;

    public FacebookMessageFactory(String content) {
        this.content = content;
    }

    @Override
    public Message createMessage(String address, Date currentDateTime) {
        return new FacebookMessage(address, "Hey, the time is: " + currentDateTime + ", " + content);

    }
}
