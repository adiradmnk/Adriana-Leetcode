package LatihanUASDDP2.SistemBurhan;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ReportEngine implements MediaExportable, MediaImportable{
    private ArrayList<Media> daftarMedia;

    public ReportEngine() {
        this.daftarMedia = new ArrayList<>();
    }

    public void exportData(String path, ReportMode mode) throws FileReportException {
        DataFileWriter writer = new DataFileWriter(path, TypeMode.CSV);
        if (mode == ReportMode.PODCAST) {
            writer.writeRow(Arrays.asList("nama podcast", "jumlah Episode", "isExplisit"));

            daftarMedia.stream().filter(x -> x instanceof Podcast).map(x -> Arrays.asList(x.getNama(),
                                                                                        x.getJumlah(),
                                                                                        x.getExplisit())).forEach(n -> writer.writeRow(n));

        }

        writer.close();
    }

    public void importData(String path, ReportMode mode) throws FileReportException, DuplicateMediaException {
        DataFileReader reader = new DataFileReader(path);
        List<String> row;

        try {
            List<String> o = reader.readNext();
            if (o != null) {
                throw new FileReportException();
            }
        } catch (FileReportException e) {
            System.out.print(e.getMessage());
        }

        while((row = reader.readNext()) != null) {
            if (ReportMode.MOVIE == mode) {
                String name = row.get(0);
                String genre = row.get(1);

                List<Movie> cocok = daftarMedia.stream().filter(x -> x instanceof Movie).map(x -> (Movie) x).toList();
            }
        }

    }
}
