package com.knd.test_nyton.dto.response;

import com.knd.test_nyton.model.MarketPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PriceHistoryResponse {
    List<MarketPrice> listOfPrices;
}
