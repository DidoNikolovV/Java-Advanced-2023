package _00_Review;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Email implements Message {

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String getTo() {
        return String.join(",", this.toAddresses);
    }

    @Override
    public String getContent() {
        return this.getText();
    }


    public static class Builder {
        private String sender;
        private List<String> toAddresses = new ArrayList<>();
        private List<String> ccAddresses = new ArrayList<>();
        private List<String> bccAddresses = new ArrayList<>();

        private String subject;
        private String text;

        private List<Attachment> attachments;
        private Date scheduledSendDate;

        public Builder setSender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder addTo(String toAddress) {
            this.toAddresses.add(toAddress);
            return this;
        }

        public Builder setToAddresses(List<String> toAddresses) {
            this.toAddresses = toAddresses;
            return this;
        }

        public Builder setCcAddresses(List<String> ccAddresses) {
            this.ccAddresses = ccAddresses;
            return this;
        }

        public Builder setBccAddresses(List<String> bccAddresses) {
            this.bccAddresses = bccAddresses;
            return this;
        }

        public Builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setAttachments(List<Attachment> attachments) {
            this.attachments = attachments;
            return this;
        }

        public Builder setScheduledSendDate(Date scheduledSendDate) {
            this.scheduledSendDate = scheduledSendDate;
            return this;
        }

        public Email build() {
            Email email = new Email(sender, toAddresses, ccAddresses, bccAddresses, subject, text, attachments, scheduledSendDate);
            return email;
        }
    }

    private String sender;
    private List<String> toAddresses;
    private List<String> ccAddresses;
    private List<String> bccAddresses;

    private String subject;
    private String text;

    private List<Attachment> attachments;
    private Date scheduledSendDate;

    public Email(String sender, List<String> toAddresses, List<String> ccAddresses, List<String> bccAddresses, String subject, String text, List<Attachment> attachments, Date scheduledSendDate) {
        this.sender = sender;
        if(toAddresses == null || toAddresses.isEmpty()) {
            throw new IllegalArgumentException("missing toAddresses");
        }
        this.toAddresses = toAddresses;
        this.ccAddresses = ccAddresses;
        this.bccAddresses = bccAddresses;

        if(subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("missing subject");
        }
        this.subject = subject;

        if(text == null || text.isEmpty()) {
            throw new IllegalArgumentException("missing text");
        }
        this.text = text;
        this.attachments = attachments;
        this.scheduledSendDate = scheduledSendDate;
    }

    public String getSender() {
        return sender;
    }

    public List<String> getToAddresses() {
        return toAddresses;
    }

    public List<String> getCcAddresses() {
        return ccAddresses;
    }

    public List<String> getBccAddresses() {
        return bccAddresses;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public Date getScheduledSendDate() {
        return scheduledSendDate;
    }

    @Override
    public String toString() {
        return "Email{" +
                "sender='" + sender + '\'' +
                ", toAddresses=" + toAddresses +
                ", ccAddresses=" + ccAddresses +
                ", bccAddresses=" + bccAddresses +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", attachments=" + attachments +
                ", scheduledSendDate=" + scheduledSendDate +
                '}';
    }
}
