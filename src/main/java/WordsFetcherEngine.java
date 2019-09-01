import historysystem.HistorySystem;
import util.SentenceActions;
import view.ApplicationMessages;

import java.util.*;

class WordsFetcherEngine {

    private static final String FILE_PATH = "Result.txt";
    private final HistorySystem historySystem;
    private final ApplicationMessages applicationMessages;
    private Scanner scanner;

    WordsFetcherEngine(HistorySystem historySystem, ApplicationMessages applicationMessages) {
        this.historySystem = historySystem;
        this.applicationMessages = applicationMessages;
        scanner = new Scanner(System.in);
    }

    void executeEngine() {
        String sentence = getSentence();

        String purifiedLowerCaseSentence = SentenceActions.getPurifiedLowerCaseSentence(sentence);
        Set<Character> characters = SentenceActions.getEveryCharacterOccurringInSentence(purifiedLowerCaseSentence);
        String[] splittedSentence = purifiedLowerCaseSentence.split("\\s");
        Map<Character, Set<String>> characterWithAccordingWord = new LinkedHashMap<>();

        for (char iteratedCharacter : characters) {
            for (String iteratedWord : splittedSentence) {
                if (iteratedWord.indexOf(iteratedCharacter) >= 0) {
                    characterWithAccordingWord.computeIfAbsent(iteratedCharacter, k -> new TreeSet<>());
                    characterWithAccordingWord.get(iteratedCharacter).add(iteratedWord);
                }
            }
        }
        historySystem.overwriteFileWithGivenResult(FILE_PATH, characterWithAccordingWord, sentence);
        applicationMessages.writeResult(characterWithAccordingWord);
    }

    private String getSentence() {
        applicationMessages.askAboutSentence();
        return scanner.nextLine();
    }
}
