package com.github.newk5.htmlparserbench;

import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.htmlcleaner.HtmlCleaner;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class HtmlUnitBench extends BaseBenchmark {
    
    HtmlCleaner cleaner;
    
    public HtmlUnitBench() {
        
        super();
    }
    
    public HtmlUnitBench(String content) {
        super(content);
    }
    
    @Setup
    public void setup() throws IOException {
        content = Files.readString(Path.of("wikipedia.html"), StandardCharsets.UTF_8);
    }
    
    @Benchmark
    public String benchmark() throws Exception {
        
        try (WebClient webClient = new WebClient()) {
            webClient.getOptions().setActiveXNative(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
            webClient.setCssErrorHandler(new SilentCssErrorHandler());
            webClient.getOptions().setDownloadImages(false);
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setRedirectEnabled(false);
            webClient.getOptions().setFetchPolyfillEnabled(false);
            final HtmlPage page = webClient.loadHtmlCodeIntoCurrentWindow(content);
            return page.getElementById("mp-dyk-h2").asXml();

        }
        
    }
    
}
