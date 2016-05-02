package fr.languor.xml;

import fr.languor.model.Error;
import fr.languor.model.ObjetReference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Report {

    @XmlElement
    private String inputFile;
    private List<ObjetReference> objetReferenceList;
    private List<Error> errorList;

    public Report() {
        this.objetReferenceList = new ArrayList<ObjetReference>();
        this.errorList = new ArrayList<Error>();
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public List<ObjetReference> getObjetReferenceList() {
        return objetReferenceList;
    }

    public void setObjetReferenceList(List<ObjetReference> objetReferenceList) {
        this.objetReferenceList = objetReferenceList;
    }

    public List<Error> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<Error> errorList) {
        this.errorList = errorList;
    }
}
