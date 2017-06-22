package org.mmpp.raspberrypi.ledflash.domain;

public class Channel {
    public Channel(String no, String color, String channel ,String label,String signal){
        super();
        this.no = no;
        this.color = color;
        this.channel = channel;
        this.label = label;
        this.signal = signal;

    }
    public String no;
    public String color;
    public String channel;
    public String label;
    public String signal;

}
