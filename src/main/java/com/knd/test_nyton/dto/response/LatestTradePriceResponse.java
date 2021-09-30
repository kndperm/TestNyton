package com.knd.test_nyton.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LatestTradePriceResponse {
    private String ticker;
    private double price;
}
