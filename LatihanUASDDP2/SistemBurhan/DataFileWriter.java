package LatihanUASDDP2.SistemBurhan;

import java.io.*;
import java.util.List;

public class DataFileWriter {
    private PrintWriter printWriter;
    private TypeMode mode;

    // bikin constructornya
    public DataFileWriter(String path, TypeMode mode) {
        try {
            this.printWriter = new PrintWriter(path);
            this.mode = mode;
        } catch (Exception e) {
            System.out.print("Gagagl membuka file untuk penulisan: " + path);
        }
    }

    // pembuatan objek untuk csv
    public DataFileWriter forCsv(String path) throws FileReportException {
        return new DataFileWriter(path, TypeMode.CSV);
    }

    // pembuatan objek untuk txt
    public DataFileWriter forTxt(String path) throws FileReportException {
        return new DataFileWriter(path, TypeMode.CSV);
    }

    // metode untuk nulis satu baris
    public void writeRow(List<String> row) {
        if (row == null ) return;

        if (mode == TypeMode.CSV) {
            printWriter.println(String.join(",", row));
        } else {
            row.stream().forEach(item -> printWriter.printf("%-20s", (item != null ? item : "")));
            printWriter.println();;
        }
        printWriter.flush();
    }

    public void close() {
        if (printWriter != null) {
            printWriter.flush();
            printWriter.close();
        }
    }




}
