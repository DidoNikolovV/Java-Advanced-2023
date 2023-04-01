package _00_Review;

public class FacebookMessage implements Message{
    String recipientAccount;
    String content;

    public FacebookMessage(String recipientAccount, String content) {
        this.recipientAccount = recipientAccount;
        this.content = content;
    }

    @Override
    public String getTo() {
        return recipientAccount;
    }

    @Override
    public String getContent() {
        return content;
    }
}
