package cz.tomasdvorak.sqlkeywords.utils;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeywordsReader {

    public static final String KEYWORDS_RESOURCE_FILE = "/keywords.txt";
    public static final String COMMENT_CHAR = "#";

    public static Set<String> getAll() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(KeywordsReader.class.getResource(KEYWORDS_RESOURCE_FILE).toURI()), Charset.defaultCharset());
            Set<String> keywords = new HashSet<>();
            for (String line : lines) {
                if (!line.trim().startsWith(COMMENT_CHAR)) {
                    keywords.add(line.trim().toLowerCase());
                }
            }
            return keywords;
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
