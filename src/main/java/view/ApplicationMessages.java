package view;

import java.util.Map;
import java.util.Set;

public interface ApplicationMessages {

    void askAboutInput();

    void displayResult(Map<Character, Set<String>> characterWithAccordingString);
}
