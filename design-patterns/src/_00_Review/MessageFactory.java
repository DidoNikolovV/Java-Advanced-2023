package _00_Review;

import java.util.Date;

public interface MessageFactory {
    public Message createMessage(String address, Date currentDateTime);
}
