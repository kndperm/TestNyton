package com.knd.test_nyton.controller;

import com.knd.test_nyton.dto.request.LatestTradePriceRequest;
import com.knd.test_nyton.dto.request.PriceHistoryRequest;
import com.knd.test_nyton.dto.response.LatestTradePriceResponse;
import com.knd.test_nyton.dto.response.PriceHistoryResponse;
import com.knd.test_nyton.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

    @Autowired
    private TradeService service;

    @GetMapping("/latest_price")
    public LatestTradePriceResponse getLatestTradePrice(@RequestBody LatestTradePriceRequest request){
        return service.getLatestTradePrice(request);
    }

    @GetMapping("/price_history")
    public PriceHistoryResponse getPriceHistory(@RequestBody PriceHistoryRequest request){
        return service.getPriceHistory(request);
    }
}
