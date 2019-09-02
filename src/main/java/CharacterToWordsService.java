import resultservice.ResultService;
import utils.SentenceUtils;
import view.ApplicationMessages;

import java.util.*;

class CharacterToWordsService {

    private static final String FILE_PATH = "Result.txt";

    private final ResultService resultService;
    private final CharacterToWordsMapper wordContainingLetterMapCreator;
    private final ApplicationMessages applicationMessages;
    private Scanner scanner;

    CharacterToWordsService(ResultService resultService, ApplicationMessages applicationMessages,
                            CharacterToWordsMapper wordContainingLetterMapCreator) {
        this.resultService = resultService;
        this.applicationMessages = applicationMessages;
        this.wordContainingLetterMapCreator = wordContainingLetterMapCreator;
        scanner = new Scanner(System.in);
    }

    void executeEngine() {
        String userInput = getUserInput();

        String[] splitPurifiedLowerCaseSentence = SentenceUtils.purifySentence(userInput);
        Map<Character, Set<String>> characterWithAccordingWord =
                wordContainingLetterMapCreator.createMapWithCharacterToAccordingWords(splitPurifiedLowerCaseSentence);

        resultService.saveResult(FILE_PATH, characterWithAccordingWord, userInput);
        applicationMessages.displayResult(characterWithAccordingWord);
    }

    private String getUserInput() {
        applicationMessages.askAboutInput();
        return scanner.nextLine();
    }
}
