package historysystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class HistorySystemServiceTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private HistorySystemService historySystemService = new HistorySystemService();

    @Test
    public void overwriteFileWithGivenResult() throws IOException {
        File rankingFile = tempFolder.newFile("History.txt");
        String rankingFilePath = rankingFile.getPath();
        Map<Character, Set<String>> actualMap = prepareActualMap();
        String sentence = "Ala ma.";

        String[] actualResultBeforeOverwriting = retrieveRatesHistory(rankingFilePath);
        String[] expectedResultBeforeOverwriting = {};

        assertArrayEquals(expectedResultBeforeOverwriting, actualResultBeforeOverwriting);

        historySystemService.overwriteFileWithGivenResult(rankingFilePath, actualMap, sentence);

        String[] afterOverwriting = retrieveRatesHistory(rankingFilePath);
        String[] expectedResultAfterOverwriting = {"The result for sentence: Ala ma.", "Result: {l=[ala], a=[ma, ala], m=[ma]}"};

        assertArrayEquals(expectedResultAfterOverwriting, afterOverwriting);
    }


    private String[] retrieveRatesHistory(String rankingFilePath) {
        try (Stream<String> contentFileStream = Files.lines(Paths.get(rankingFilePath))) {
            return contentFileStream.toArray(String[]::new);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Map<Character, Set<String>> prepareActualMap() {
        Map<Character, Set<String>> map = new LinkedHashMap<>();
        Set<String> lSet = Stream.of("ala").collect(Collectors.toSet());
        Set<String> aSet = Stream.of("ala", "ma").collect(Collectors.toSet());
        Set<String> mSet = Stream.of("ma").collect(Collectors.toSet());
        map.put('l', lSet);
        map.put('a', aSet);
        map.put('m', mSet);
        return map;
    }

}
