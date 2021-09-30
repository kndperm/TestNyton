package com.knd.test_nyton.service;

import com.knd.test_nyton.dto.request.LatestTradePriceRequest;
import com.knd.test_nyton.dto.request.PriceHistoryRequest;
import com.knd.test_nyton.dto.response.LatestTradePriceResponse;
import com.knd.test_nyton.dto.response.PriceHistoryResponse;
import com.knd.test_nyton.model.MarketPrice;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TradeService {

    private WebClient webClient;

    public TradeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public LatestTradePriceResponse getLatestTradePrice(LatestTradePriceRequest request) {
        String requestURI = "/iss/engines/stock/markets/shares/securities/" + request.getTicker()
                + "/trades.json?iss.only=trades&trades.columns=SECID,PRICE";
        JSONArray trades = getDataFromAPI(requestURI, "trades");
        JSONArray lastTradeJSON = trades.getJSONArray(trades.length() - 1);
        return new LatestTradePriceResponse(lastTradeJSON.getString(0), lastTradeJSON.getDouble(1));
    }

    @Cacheable("PriceHistoryCache")
    public PriceHistoryResponse getPriceHistory(PriceHistoryRequest request) {
        List<MarketPrice> marketPriceList = new ArrayList<>();

        String requestURI = "/iss/history/engines/stock/markets/index/securities/" + request.getTicker()
                + "/.json?from=" + request.getFrom().toString() + "&till=" + request.getTill().toString() +
                "&iss.only=history&history.columns=SECID,TRADEDATE,VALUE";
        JSONArray marketDataJSON = getDataFromAPI(requestURI, "history");

        for (int i = 0; i < marketDataJSON.length(); i++) {
            JSONArray data = marketDataJSON.getJSONArray(i);
            MarketPrice marketPrice = new MarketPrice(data.getString(0), data.getDouble(2),
                    LocalDate.parse(data.getString(1)));
            marketPriceList.add(marketPrice);
        }

        return new PriceHistoryResponse(marketPriceList);
    }

    private JSONArray getDataFromAPI(String requestURI, String base) {
        JSONObject jsonObject = getJSONFromMOEX(requestURI);
        return JSONParser.getJSONArrayFromMOEXJson(jsonObject, base);
    }

    private JSONObject getJSONFromMOEX(String requestURI) {
        Mono<String> jsonObjectMono = webClient.get().uri(requestURI).retrieve().bodyToMono(String.class);
        String tmp = jsonObjectMono.block();
        return new JSONObject(tmp);
    }
}
