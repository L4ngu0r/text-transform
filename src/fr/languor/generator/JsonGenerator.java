package fr.languor.generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import fr.languor.model.Report;

import java.io.File;
import java.io.IOException;

public class JsonGenerator extends Generator {

    public JsonGenerator(Report report, String outputPath) {
        super(report, outputPath);
    }

    public void run() throws Exception {
        if (this.report == null) {
            throw new Exception("[JSONGenerator] No report has been set ! Please check class constructor.");
        }
        if (this.outputPath == null || this.outputPath.length() == 0) {
            throw new Exception("No output path has been set !");
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File(this.outputPath), this.report);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
