package com.mitchellbosecke.benchmark;

import com.github.newk5.htmlparserbench.NekoHTMLBench;
import com.github.newk5.htmlparserbench.JerryBench;
import com.github.newk5.htmlparserbench.JFiveParseBench;
import com.github.newk5.htmlparserbench.HtmlUnitBench;
import com.github.newk5.htmlparserbench.HTMLCleanerBench;
import com.github.newk5.htmlparserbench.JsoupBench;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.BeforeClass;
import org.junit.Test;





public class Tests {

    private static String content;

    @BeforeClass
    public static void beforeClass() throws IOException {

        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

  
    @Test
    public void testJsoup() throws Exception {
        JsoupBench b = new JsoupBench(content);
        b.benchmark();
    }

    @Test
    public void testJerry() throws Exception {
        JerryBench b = new JerryBench(content);
        b.benchmark();
    }

    @Test
    public void testJfive() throws Exception {
        JFiveParseBench b = new JFiveParseBench(content);
        b.benchmark();
    }

    @Test
    public void testNekoHTML() throws Exception {
        NekoHTMLBench b = new NekoHTMLBench(content);
        b.benchmark();
    }

    @Test
    public void testHTMLCleaner() throws Exception {
        HTMLCleanerBench b = new HTMLCleanerBench(content);
        b.benchmark();
    }

    @Test
    public void testHTMLUnit() throws Exception {
        HtmlUnitBench b = new HtmlUnitBench(content);
        b.benchmark();
    }

}
