import resultservice.ResultService;
import resultservice.ResultFileService;
import view.ApplicationMessages;
import view.ConsoleMessages;

public class Main {
    public static void main(String[] args) {

        ResultService resultService = new ResultFileService();
        ApplicationMessages applicationMessages = new ConsoleMessages();
        CharacterToWordsMapper wordContainingLetterMapCreator = new CharacterToWordsMapper();

        CharacterToWordsService wordsFetcherEngine = new CharacterToWordsService(
                resultService,
                applicationMessages,
                wordContainingLetterMapCreator
        );

        wordsFetcherEngine.executeEngine();
    }
}
