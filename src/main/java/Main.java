import historysystem.ResultService;
import historysystem.ResultFileService;
import view.ApplicationMessages;
import view.ConsoleMessages;

public class Main {
    public static void main(String[] args) {

        ResultService historySystemService = new ResultFileService();
        ApplicationMessages applicationMessages = new ConsoleMessages();
        CharacterToWordsMapper wordContainingLetterMapCreator = new CharacterToWordsMapper();

        CharacterToWordsService wordsFetcherEngine = new CharacterToWordsService(
                historySystemService,
                applicationMessages,
                wordContainingLetterMapCreator
        );

        wordsFetcherEngine.executeEngine();
    }
}
