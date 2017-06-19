package org.mmpp.raspberrypi.ledflash.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class GPIO implements Serializable{

    @Id
    @GeneratedValue
    public Long id;

    @Column
    public String channel;

    @Column
    public String type;

}
