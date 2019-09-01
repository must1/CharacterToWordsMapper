package view;

import java.util.Map;
import java.util.Set;

public class ConsoleMessages implements ApplicationMessages {

    @Override
    public void askAboutSentence() {
        System.out.println("Please, provide your sentence.");
    }

    @Override
    public void writeResult(Map<Character, Set<String>> characterWithAccordingString) {
        System.out.println("The result is: " + characterWithAccordingString);
    }
}
