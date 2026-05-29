package LatihanUASDDP2.SistemBurhan;

public interface MediaImportable {
    void importData(String path, ReportMode mode) throws FileReportException, DuplicateMediaException;
}
