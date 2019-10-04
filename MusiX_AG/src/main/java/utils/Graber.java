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
        Document doc = Jsoup.connect(url).get();
        Element content = doc.getElementById("оно вообще нужно тут?");
        Elements links = content.select(".prod-pricebox-price-primary span.primary");
        for (Element link : links) {
            String linkText = link.text();
        }
        return price;
    }
}
