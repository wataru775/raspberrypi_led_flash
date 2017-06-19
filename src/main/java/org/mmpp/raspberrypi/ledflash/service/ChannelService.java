package org.mmpp.raspberrypi.ledflash.service;

import org.mmpp.raspberrypi.ledflash.domain.Channel;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ChannelService {


    public List<Channel> findAll(){
        List<Channel> channels = new LinkedList<>();
        channels.add(new Channel("1","緑","GPIO_16","15"));
        channels.add(new Channel("2","緑","GPIO_15","16"));

        return channels;
    }
}
