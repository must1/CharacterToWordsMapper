package historysystem;

import java.util.Map;
import java.util.Set;

public interface HistorySystem {

    void overwriteFileWithGivenResult(String filePath,
                                      Map<Character, Set<String>> characterWithAccordingWords,
                                      String sentence);
}