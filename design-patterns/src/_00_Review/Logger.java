package _00_Review;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private static Logger loggerInstance;

    public static synchronized Logger get() {
        if(loggerInstance == null) {
            loggerInstance = new Logger();
        }

        return loggerInstance;
    }

    private BufferedWriter logWriter;
    private Logger() {
        try {
            logWriter = new BufferedWriter(new FileWriter("log-create-" + new Date().getTime() + ".txt", true));
        } catch(IOException e) {
            System.out.println("Failed to setup logger. No logs will be available. Error details below:");
            e.printStackTrace();
        }
    }

    public void writeMessage(String logMessage) {
        try {
            logWriter.write(logMessage);
            logWriter.write(System.lineSeparator());
            logWriter.flush();
        } catch(IOException e) {
            System.out.println("Failed to write message to log. Error details below:");
            e.printStackTrace();
        }
    }
}
