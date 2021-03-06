package ua.scadge.difftool;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LongestCommonSublistTest {
    @Test
    public void longestCommonSublist() {
        try {
            final URL linesBeforeUrl = getClass().getClassLoader().getResource("before.txt");
            Assert.assertNotNull("Initial text file not found", linesBeforeUrl);

            final URL linesAfterUrl = getClass().getClassLoader().getResource("after.txt");
            Assert.assertNotNull("Resulting text file not found", linesAfterUrl);

            final List<String> linesBefore = Files.readAllLines(Paths.get(linesBeforeUrl.toURI()));
            final List<String> linesAfter = Files.readAllLines(Paths.get(linesAfterUrl.toURI()));

            final List commonSublist = new LongestCommonSublist(linesBefore, linesAfter);

            List<String> expected = new ArrayList<>();
            expected.add("Text");
            expected.add("File");

            Assert.assertEquals("Wrong common sublist", expected, commonSublist);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
