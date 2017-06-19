package org.mmpp.raspberrypi.ledflash.controller;

import org.mmpp.raspberrypi.ledflash.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class ListController {

    @Autowired
    public ChannelService channelService;

    @RequestMapping()
    public String list(Model model){
        model.addAttribute("channels", channelService.findAll());
        return "list";
    }

}
