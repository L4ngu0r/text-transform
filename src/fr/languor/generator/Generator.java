package fr.languor.generator;

import fr.languor.xml.Report;

public class Generator {

    protected Report report;
    protected String outputPath;

    public Generator(Report report, String outputPath) {
        this.report = report;
        this.outputPath = outputPath;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
