package com.gk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by yws on 5/14/17.
 */
@Controller
public class WebController {

    @GetMapping("/answer")
    public String index() {
        return "forward:/answer/index.html";
    }

    @GetMapping("/webSystem")
    public String webIndex() {
        return "forward:/webSystem/index.html";
    }

}
