package com.olegao.firstSpringBootApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {
    Fetcher fetcher = new Fetcher(Application.xmlFilePath);

    @RequestMapping("/tagbody")
    public String getTagBody(@RequestParam(value = "name", defaultValue = "") String name) {
        String tagBody;
        try {
            tagBody = fetcher.fetch(name);
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
        return tagBody;
    }
}
