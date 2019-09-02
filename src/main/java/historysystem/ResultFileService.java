package historysystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class ResultFileService implements ResultService {

    public void saveResult(String filePath,
                           Map<Character, Set<String>> characterWithAccordingWords,
                           String sentence) {

        try (FileWriter writer = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            bufferedWriter.write("The result for sentence: " + sentence);
            bufferedWriter.newLine();
            bufferedWriter.write("Result: " + characterWithAccordingWords);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
