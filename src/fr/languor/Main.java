package fr.languor;

import fr.languor.generator.JsonGenerator;
import fr.languor.generator.XmlGenerator;
import fr.languor.model.Format;
import fr.languor.model.ObjetReference;
import fr.languor.valid.Validator;
import fr.languor.model.Report;
import fr.languor.model.Error;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String inputFile = null;
        String outputFile = null;
        int format = 0;

        // TODO handle error on arguments
        if(args.length == 0){
            System.out.println("[INFO] No arguments passed ! Using default value");
        }

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println("Argument " + i + " : " + arg);
            switch (i) {
                case 0:
                    // first argument is path to input text file
                    inputFile = args[i];
                    break;
                case 1:
                    // second argument is format : xml or json
                    format = Integer.parseInt(args[i]);
                    break;
                case 2:
                    // third argument is path to output file
                    outputFile = args[i];
                    break;
            }
        }

        // TODO handle default cases
        if (inputFile == null) {
            inputFile = "./entry/text.txt";
        }
        if (outputFile == null) {
            outputFile = "./output/text.xml";
        }

        File file = new File(inputFile);
        Scanner input;
        Report ref = new Report();
        ref.setInputFile(file.getName());
        try {
            input = new Scanner(file);
            int lineIndex = 1;
            while (input.hasNext()) {
                String nextToken = input.next();
                String[] splitedLine = nextToken.split(";");

                Boolean validLength = Validator.checkReferenceLength(splitedLine[0]);
                Boolean validColor = Validator.checkColorValues(splitedLine[1]);

                if (validLength && validColor) {
                    ObjetReference o = new ObjetReference();
                    o.setReference(Integer.parseInt(splitedLine[0]));
                    o.setColor(splitedLine[1]);
                    o.setPrice(Float.parseFloat(splitedLine[2]));
                    o.setSize(Integer.parseInt(splitedLine[3]));

                    ref.getObjetReferenceList().add(o);
                } else if (!validLength && validColor) {
                    Error e = new Error(lineIndex, "Reference is wrong", nextToken);
                    ref.getErrorList().add(e);
                } else {
                    Error e = new Error(lineIndex, "Incorrect value for color", nextToken);
                    ref.getErrorList().add(e);
                }
                lineIndex++;
            }
            input.close();

            System.out.println(ref.getObjetReferenceList().size() + " added to convert queue");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // generate JSON
        if (format == Format.JSON_TYPE) {
            JsonGenerator jsonGenerator = new JsonGenerator(ref, outputFile);
            try {
                jsonGenerator.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // generate XML
        if (format == Format.XML_TYPE) {
            XmlGenerator xmlGenerator = new XmlGenerator(ref, outputFile);
            try {
                xmlGenerator.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
