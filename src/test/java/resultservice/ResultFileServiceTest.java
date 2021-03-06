package resultservice;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

public class ResultFileServiceTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private ResultFileService resultFileService = new ResultFileService();

    @Test
    public void saveResultTest() throws IOException {
        //given
        File rankingFile = tempFolder.newFile("Result.txt");
        String rankingFilePath = rankingFile.getPath();
        Map<Character, Set<String>> actualMap = prepareActualMap();
        String sentence = "Ala ma.";
        String[] expectedResultAfterOverwriting =
                {"The result for sentence: Ala ma.", "Result: {a=[ma, ala], l=[ala], m=[ma]}"};
        //when
        resultFileService.saveResult(rankingFilePath, actualMap, sentence);

        //then
        assertArrayEquals(expectedResultAfterOverwriting, retrieveResult(rankingFilePath));
    }


    private String[] retrieveResult(String rankingFilePath) {
        try (Stream<String> contentFileStream = Files.lines(Paths.get(rankingFilePath))) {
            return contentFileStream.toArray(String[]::new);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private Map<Character, Set<String>> prepareActualMap() {
        Map<Character, Set<String>> map = new TreeMap<>();
        Set<String> lSet = Stream.of("ala").collect(Collectors.toSet());
        Set<String> aSet = Stream.of("ala", "ma").collect(Collectors.toSet());
        Set<String> mSet = Stream.of("ma").collect(Collectors.toSet());
        map.put('l', lSet);
        map.put('a', aSet);
        map.put('m', mSet);
        return map;
    }
}
