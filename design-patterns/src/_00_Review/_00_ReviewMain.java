package _00_Review;

public class _00_ReviewMain {
    public static void main(String[] args) {
        Logger.get().writeMessage("executing main()");
        // Builder example:
        Email email = Email.builder()
                .setSender("dido@example.com")
                .addTo("someone@example.com")
                .setSubject("Design patterns")
                .setText("Hello someone, please explain me build pattern")
                .build();

    }
}
