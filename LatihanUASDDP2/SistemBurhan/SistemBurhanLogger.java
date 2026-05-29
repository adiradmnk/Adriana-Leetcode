package LatihanUASDDP2.SistemBurhan;
import java.time.*;
import java.time.format.DateTimeFormatter;

import java.io.*;

public class SistemBurhanLogger {
    private static SistemBurhanLogger instance;
    private String path = "guild_history.txt";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // ini nyimpen formatnya

    private SistemBurhanLogger(){}

    public static SistemBurhanLogger getInstance() {
        if (instance == null) {
            instance = new SistemBurhanLogger();
        }
        return instance;
    }

    private void writeToFile(String message) {
        String timeStamp = LocalDateTime.now().format(formatter); // ini bikin
        String finalmessage = String.format("[BurhanLogger] %s : %s", timeStamp, message);

        try {
            PrintWriter writer = new PrintWriter(path);
            writer.write(finalmessage);
            writer.println();
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        }

    }

    public void log(LogCategory n, String pesan) {
        String n = String.format("[", null)
    }
}
