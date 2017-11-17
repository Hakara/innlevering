package innlevering1;

import java.io.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputReader {
    public static void main (String [] args){

        //filnavn
        String fileName = "emner.txt";

        //Stream leser filen, tar vare på informasjonen
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            //singlesubjects array
            String[] singleSubjects = stream.toArray(String[]::new);
            //subjects i kommaseparert format
            Stream.of(singleSubjects).forEach(System.out::println);
            for (String s: singleSubjects) {
                String[] subjectAttributes = s.split(",");
                Subject subject = new Subject(subjectAttributes);
                System.out.println(subject.getRomNr());
                DBConnector.persistSubject(subject);
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("unable to open file '" + fileName + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");

        }


    }
}
