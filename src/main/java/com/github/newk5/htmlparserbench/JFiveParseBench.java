package com.github.newk5.htmlparserbench;

import ch.digitalfondue.jfiveparse.Document;
import ch.digitalfondue.jfiveparse.Element;
import ch.digitalfondue.jfiveparse.JFiveParse;
import ch.digitalfondue.jfiveparse.Node;
import ch.digitalfondue.jfiveparse.NodeMatcher;
import ch.digitalfondue.jfiveparse.Selector;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class JFiveParseBench extends BaseBenchmark {

    public JFiveParseBench() {
        super();
    }

    public JFiveParseBench(String content) {
        super(content);
    }

    @Setup
    public void setup() throws IOException {

        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

    @Benchmark
    public String benchmark() throws Exception {
        Document doc = JFiveParse.parse(content);
        NodeMatcher matcher = Selector.select().id("mp-dyk-h2").toMatcher();
        Node n = doc.getAllNodesMatching(matcher).stream().findFirst().get();
        Element e = (Element) n;
        String c = e.getOuterHTML();
        return c;
    }

}
