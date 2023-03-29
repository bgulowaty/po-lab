package pl.pwr.io;

import org.jsoup.Jsoup;

import java.io.IOException;

public class PageDownloader {

    private PageDownloader() {
    }

    public static String getText(String url) {
        try {
            return Jsoup.connect(url).get().text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
