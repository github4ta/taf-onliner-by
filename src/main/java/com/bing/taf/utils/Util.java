package com.bing.taf.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Util {
    public static Element getHtmlElementByXpath(String html, String xPath) {
        Document document = Jsoup.parse(html);
        Element bodyElement = document.body();
        return bodyElement
                .selectXpath(xPath)
                .first();
    }
}
