package com.knd.test_nyton.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Trade {
    private long tradeNo;
    private LocalTime time;
    private String boarId;
    private String secId;
    private double price;
    private int quantity;
    private double value;
    private String period;
    private int tradeTime_GRP;
    private LocalDateTime sysTime;
    private String buySell;
    private int decimals;
    private String tradingSession;
}
