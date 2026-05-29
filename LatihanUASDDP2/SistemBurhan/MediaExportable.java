package LatihanUASDDP2.SistemBurhan;

public interface MediaExportable {
    void exportData(String path, ReportMode mode) throws FileReportException;
}
