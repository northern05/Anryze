package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;

public class Graber {
    private String title;
    private String price;

    public Graber(String title, String price) {
        this.title = title;
        this.price = price;
    }

    public String titleAndPriceGrabber(String url) throws IOException {
        File input = new File("/tmp/input.html");
        Document doc = Jsoup.parse(input, "UTF-8", url);

        Element content = doc.getElementById("title");
        Elements links = content.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href");
            String linkText = link.text();
        }
        return price;
    }
}
