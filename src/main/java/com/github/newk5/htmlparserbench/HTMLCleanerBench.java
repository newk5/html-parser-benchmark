package com.github.newk5.htmlparserbench;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class HTMLCleanerBench extends BaseBenchmark {

    HtmlCleaner cleaner;

    public HTMLCleanerBench() {

        super();
    }

    public HTMLCleanerBench(String content) {
        super(content);
    }

    @Setup
    public void setup() throws IOException {

        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

    @Benchmark
    public String benchmark() throws Exception {
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode n = cleaner.clean(content);
        return n.getElementsByAttValue("id", "mp-dyk-h2", true, true)[0].getText().toString();
    }

}
