package view;

import java.util.Map;
import java.util.Set;

public interface ApplicationMessages {

    void askAboutSentence();

    void writeResult(Map<Character, Set<String>> characterWithAccordingString);
}
