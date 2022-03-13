package com.github.newk5.htmlparserbench;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import jodd.jerry.Jerry;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class JerryBench extends BaseBenchmark {

    public JerryBench() {
        super();
    }

    public JerryBench(String content) {
        super(content);
    }

    @Setup
    public void setup() throws IOException {
      
        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

    @Benchmark
    public String benchmark() throws Exception {
        Jerry doc = Jerry.of(content);

        String c = doc.s("#mp-dyk-h2").html();
        return c;
    }

}
