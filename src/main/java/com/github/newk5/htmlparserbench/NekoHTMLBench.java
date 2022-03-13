package com.github.newk5.htmlparserbench;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.cyberneko.html.parsers.DOMParser;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.xml.sax.InputSource;

public class NekoHTMLBench extends BaseBenchmark {

    public NekoHTMLBench() {
        super();
    }

    public NekoHTMLBench(String content) {
        super(content);
    }

    @Setup
    public void setup() throws IOException {
       
        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

    @Benchmark
    public String benchmark() throws Exception {
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(new ByteArrayInputStream(content.getBytes())));
        

        String c =parser.getDocument().getElementById("mp-dyk-h2").getTextContent();

        return c;
    }

}
