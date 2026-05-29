package LatihanUASDDP2.SistemBurhan;
import java.io.*;
import java.util.*;

public class DataFileReader {
    private Scanner sc;
    private String path;

    public DataFileReader(String path) throws FileReportException {
        this.path = path;

        if (!path.endsWith(".csv")) {
            throw new FileReportException();
        }
        try {
            this.sc = new Scanner(path);

        } catch (Exception e){
            System.out.print(e.getMessage());
        }
    }


    public List<String> readNext() throws FileReportException {
        if (sc == null || !sc.hasNextLine()) {
            return null;
        }

        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            return readNext();
        }

        String[] split = line.split(",");

        return Arrays.asList(split);
    }

    public void close() {
        if (sc != null) {
            sc.close();
            sc = null;
        }
    }
}
