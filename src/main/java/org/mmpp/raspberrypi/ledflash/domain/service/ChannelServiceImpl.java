package org.mmpp.raspberrypi.ledflash.domain.service;

import org.mmpp.raspberrypi.ledflash.domain.Channel;
import org.mmpp.raspberrypi.ledflash.domain.dao.GPIODao;
import org.mmpp.raspberrypi.ledflash.domain.model.GPIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ChannelServiceImpl implements ChannelService{

    @Autowired
    private GPIODao gpioDao;

    @Override
    public List<Channel> findAll(){
        List<Channel> channels = new LinkedList<>();
        channels.add(new Channel("1", "緑", "GPIO_16", "15"));
        channels.add(new Channel("2", "緑", "GPIO_15", "16"));
        for(Object result : gpioDao.findAll()) {
            GPIO gpio = (GPIO)result;
            channels.add(new Channel(gpio.channel, "緑", "GPIO_15", "16"));

        }
        return channels;
    }
}
