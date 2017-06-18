package org.mmpp.raspberrypi.ledflash.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class ListController {

    @RequestMapping()
    public String list(Model model){
        return "list";
    }

}
