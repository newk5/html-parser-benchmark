package com.github.newk5.htmlparserbench;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import net.htmlparser.jericho.Segment;
import net.htmlparser.jericho.Source;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class JerichoBench extends BaseBenchmark {

    public JerichoBench() {
        super();
    }

    public JerichoBench(String content) {
        super(content);
    }

    @Setup
    public void setup() throws IOException {

        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }

    @Benchmark
    public String benchmark() throws Exception {
        Source source = new Source(content);
        Segment seg = source.getElementById("mp-dyk-h2");

        String c = seg.toString();
       
        return c;
    }

}
