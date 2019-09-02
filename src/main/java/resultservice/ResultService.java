package resultservice;

import java.util.Map;
import java.util.Set;

public interface ResultService {

    void saveResult(String filePath,
                    Map<Character, Set<String>> characterWithAccordingWords,
                    String sentence);
}