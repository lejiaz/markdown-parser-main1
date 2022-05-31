import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParseTest{

    @Test
    public void addition(){
        assertEquals(2, 1+1);
    }
    //some change here

    @Test
    public void testGetLinks() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>(); 
        expected.add("https://something.com");
        expected.add("some-thing.html");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks2() throws IOException{
        Path fileName = Path.of("test-file-2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>(); 
        expected.add("a-)");
        expected.add("https://minesweeperonline.com/#200");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks3() throws IOException{
        Path fileName = Path.of("test-file-3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks4() throws IOException{
        Path fileName = Path.of("test-file-4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://minesweeperonline.com/#200");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks5() throws IOException{
        Path fileName = Path.of("test-file-5.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("");
        assertEquals(expected, links);
    }

    @Test
    public void testSnippet1() throws IOException{
        Path fileName = Path.of("snippet-1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("[a link](url.com)");
        expected.add("another link`");
        expected.add("cod[e");
        expected.add("code]");
        assertEquals(expected, links);
    }

    @Test
    public void testSnippet2() throws IOException{
        Path fileName = Path.of("snippet-2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("[a nested link](b.com)");
        expected.add("a nested parenthesized url");
        expected.add("some escaped [ brackets ]");
        assertEquals(expected, links);
    }

    @Test
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("snippet-3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("[this title text is really long and takes up more than one line");
        expected.add("and has some line breaks]( https://www.twitter.com )");
        expected.add("this title text is really long and takes up more than one line");
        expected.add("[this link doesn't have a closing parenthesis](github.com");
        expected.add("And there's still some more text after that.");
        expected.add("[this link doesn't have a closing parenthesis for a while](https://cse.ucsd.edu/");
        expected.add(")");
        expected.add("And then there's more text");
        assertEquals(expected, links);
    }
}
