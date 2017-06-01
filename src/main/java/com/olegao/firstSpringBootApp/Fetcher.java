package com.olegao.firstSpringBootApp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Fetcher {
    private String path;

    public Fetcher(String path){
        this.path = path;
    }

    public String fetch(String tagName) throws IOException {
        String xml = readFile(this.path, StandardCharsets.UTF_8);
        String response;
        StringBuilder sb = new StringBuilder();
        Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
        Element el = doc.select(tagName).first();
        if (el != null){

            if (el.children().size() == 0) {
                response = el.text();
            }
            else {
                for (Element e : el.children()) {
                    sb.append(e);
                }
                response = sb.toString();
            }
            if (!response.equals("")) return response;
        }
        return "Нет такого тега";
    }

    private static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
