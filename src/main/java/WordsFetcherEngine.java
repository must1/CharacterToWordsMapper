import historysystem.HistorySystem;
import util.SentenceActions;
import view.ApplicationMessages;

import java.util.*;

class WordsFetcherEngine {

    private static final String FILE_PATH = "Result.txt";
    private final HistorySystem historySystem;
    private final WordContainingLetterMapCreator wordContainingLetterMapCreator;
    private final ApplicationMessages applicationMessages;
    private Scanner scanner;

    WordsFetcherEngine(HistorySystem historySystem, ApplicationMessages applicationMessages,
                       WordContainingLetterMapCreator wordContainingLetterMapCreator) {
        this.historySystem = historySystem;
        this.applicationMessages = applicationMessages;
        this.wordContainingLetterMapCreator = wordContainingLetterMapCreator;
        scanner = new Scanner(System.in);
    }

    void executeEngine() {
        String sentence = getSentence();

        String purifiedLowerCaseSentence = SentenceActions.getPurifiedLowerCaseSentence(sentence);
        Set<Character> characters = SentenceActions.getEveryCharacterOccurringInSentence(purifiedLowerCaseSentence);
        String[] splittedSentence = purifiedLowerCaseSentence.split("\\s");
        Map<Character, Set<String>> characterWithAccordingWord =
                wordContainingLetterMapCreator.prepareCharacterWithAccordingWordsMap(characters, splittedSentence);

        historySystem.overwriteFileWithGivenResult(FILE_PATH, characterWithAccordingWord, sentence);
        applicationMessages.writeResult(characterWithAccordingWord);
    }

    private String getSentence() {
        applicationMessages.askAboutSentence();
        return scanner.nextLine();
    }
}
