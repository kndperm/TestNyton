package com.knd.test_nyton.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MarketPrice {
    private String ticker;
    private double price;
    private LocalDate date;
}
