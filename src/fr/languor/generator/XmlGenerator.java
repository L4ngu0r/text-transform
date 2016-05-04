package fr.languor.generator;

import fr.languor.model.Report;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlGenerator extends Generator {

    public XmlGenerator(Report report, String outputPath) {
        super(report, outputPath);
    }

    public void run() throws Exception {
        if (this.report == null) {
            throw new Exception("[XMLGenerator] No report has been set ! Please check class constructor.");
        }
        if (this.outputPath == null || this.outputPath.length() == 0) {
            throw new Exception("No output path has been set !");
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Report.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(this.report, new File(this.outputPath));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
