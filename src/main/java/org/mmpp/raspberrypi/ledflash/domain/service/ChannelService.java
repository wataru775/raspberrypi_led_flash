package org.mmpp.raspberrypi.ledflash.domain.service;

import org.mmpp.raspberrypi.ledflash.domain.Channel;

import java.util.List;

/**
 * Created by wataru on 2017/06/19.
 */
public interface ChannelService {
    public List<Channel> findAll();
}
