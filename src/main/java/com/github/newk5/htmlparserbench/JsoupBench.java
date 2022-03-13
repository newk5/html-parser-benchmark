package com.github.newk5.htmlparserbench;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class JsoupBench extends BaseBenchmark {

    public JsoupBench() {
        super();
    }

    public JsoupBench(String content) {
        super(content);
    }

    @Setup
    public void setup() throws IOException {
        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

    @Benchmark
    public String benchmark() throws Exception {
        Document doc = Jsoup.parse(content);
        Element el = doc.getElementById("mp-dyk-h2");
        String c = el.toString();
        return c;
    }

}
